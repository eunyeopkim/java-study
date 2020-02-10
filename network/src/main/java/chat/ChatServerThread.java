package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ChatServerThread extends Thread {
	private String nickName = null;
	private Socket socket = null;
	private List<Writer> listWriters;
	private Map<String, Object> map;
	private BufferedReader bufferedReader = null;
	private PrintWriter printWriter = null;
	private String[] tokens;

	public ChatServerThread(Socket socket, List<Writer> listWriters, Map<String, Object> map) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.map = map;
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); // 반대편소켓가져옴
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		log("connected " + remoteHostAddress + remotePort);

		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			while (true) {
				String request = bufferedReader.readLine();
				if (request == null) {
					doQuit(printWriter);
					ChatServer.log("#" + Thread.currentThread().getId() + "클라이언트로 부터 연결 끊김");
					break;
				}
				tokens = request.split(":");

				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					try {
						doMessage(tokens[1]);
					} catch (Exception e) {
						doMessage(" ");
					}
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
					break;
				} else if ("to".equals(tokens[0]) && tokens.length > 2) {
					doWhisper(tokens[1], tokens[2]);
				} else if ("ban".equals(tokens[0]) && tokens.length == 2) {
					doBan(tokens[1]);
				} else {
					// ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
					if ("to".equals(tokens[0])) {
						printWriter.println("<<to 잘못된 명령어 입니다.>> ex)/to : 사용자 이름 : message/");
						printWriter.flush();
					} else if ("ban".equals(tokens[0])) {
						printWriter.println("<<ban 잘못된 명령어 입니다.>> ex)/ban : 사용자 이름/");
						printWriter.flush();
					}

				}
			}

//				else {
//
//					ChatServer.log("에러:알수 없는 요청(" + tokens[0] + ")");
//
//				}

		} catch (ArrayIndexOutOfBoundsException e) {
			log(this.nickName + "이 Array를 초과했습니다.");
			doQuit(printWriter);
		} catch (IOException e) {
			log(this.nickName + "님이 채팅방을 나갔습니다.");
			doQuit(printWriter);
		} finally {
			try {
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void doJoin(String nickName, Writer writer) {
		Date now = new Date();
		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd-hh시 mm분 ss초");
		String day = sdfd.format(now);
		this.nickName = nickName;
		/* writer pool에 저장 */
		addWriter(nickName, writer);
		// 시간 출력 기능
		String data = nickName + "님이 참여하였습니다. " + day;
		broadcast(data);
		if (listWriters.size() == 1) {
			String data2 = "채팅방에 본인만 있습니다.";
			broadcast(data2);
			String data3 = "방장이 되었습니다.";
			broadcast(data3);
		}

		// ack
		PrintWriter pw = (PrintWriter) writer;
		pw.println("join:ok");
		pw.flush();

	}

	private void addWriter(String nickName, Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
		synchronized (map) {
			map.put(nickName, writer);
		}

	}

	private void doMessage(String message) {
		broadcast(nickName + ":" + message);
	}

	private void doQuit(PrintWriter pw) {
		if (listWriters.get(0) == this.printWriter && listWriters.size() > 1) {
			// 방장 위임 기능
			PrintWriter printWriter = (PrintWriter) listWriters.get(1);
			printWriter.println("방장을 위임받았습니다.");
			printWriter.flush();
		}
		removeWriter(pw);

		String data = this.nickName + "님이 퇴장하였습니다.";
		broadcast(data);
		if (listWriters.size() == 1) {
			String data2 = "채팅방에 아무도 없습니다.";
			broadcast(data2);
		}

	}

	private void doWhisper(String nickName, String data) {
		// 귓속말 기능
		boolean find = false;
		PrintWriter printWriter = null;
		for (String key : map.keySet()) {
			if (key.equals(nickName)) {
				find = true;
				printWriter = (PrintWriter) map.get(key);
				printWriter.println(this.nickName + "님의 귓속말 : " + data);
				printWriter.flush();
				break;
			}
		}
		if (find) {
			printWriter = (PrintWriter) map.get(this.nickName);
			printWriter.println(nickName + "님에게 귓속말 : " + data);
			printWriter.flush();
		} else {
			printWriter = (PrintWriter) map.get(this.nickName);
			printWriter.println("<<" + data + "님이 없습니다.>>");
			printWriter.flush();
		}

	}

	private void doBan(String nickName) {
		/*
		 * 밴 기능 리스트중에 사용자 지정, 명령어 입력으로 지정된 사용자가 자동으로 quit되게
		 * 
		 */
		boolean find = false;
		if (listWriters.get(0) == this.printWriter) {
			for (String key : map.keySet()) {
				if (key.equals(nickName))
					find = true;
			}
			if (!find) {
				PrintWriter printWriter = (PrintWriter) map.get(this.nickName);
				printWriter.println("<<" + nickName + "은(는) 존재하지 않는 사용자 입니다.>>");
				printWriter.flush();
				return;
			}

			for (String key : map.keySet()) {
				if (!key.equals(nickName)) {
					PrintWriter printWriter = (PrintWriter) map.get(key);
					printWriter.println("<<" + nickName + "님을 추방했습니다.>>");
				} else {
					PrintWriter printWriter = (PrintWriter) map.get(key);
					printWriter.println("ban");
					printWriter.flush();
				}
			}
		} else {
			PrintWriter printWriter = (PrintWriter) map.get(this.nickName);
			printWriter.println("알림! 당신은 방장이 아닙니다.");
			printWriter.flush();
		}

	}

	private void removeWriter(Writer writer) {

		synchronized (listWriters) {
			listWriters.remove(writer);
		}

	}

	private void broadcast(String data) {

		synchronized (listWriters) {

			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}

		}

	}

	public void log(String log) {
		System.out.println("[server] " + log);

	}

}
