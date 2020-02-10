package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatClient {
	private static final String ADDRESS = "0.0.0.0";
	private static final int PORT = 9998;
	static List<Writer> listWriters = new ArrayList<Writer>();

	public static void main(String[] args) {

		Scanner scanner = null;
		Socket socket = null;

		try {

			// 1. 키보드 연결
			scanner = new Scanner(System.in);

			// 2. Sockect 생성
			socket = new Socket();

			// 3. 서버 연결
			socket.connect(new InetSocketAddress(ADDRESS, PORT));
			log("connected");

			// 4. IOStream 생성(받아오기)
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			System.out.println(nickname + "님이 참여하였습니다.");
			pw.println("join:" + nickname);
			pw.flush();
			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(socket, listWriters).start();

			// 7. 키보드 입력 처리
			while (true) {
				String input = scanner.nextLine();
				if ("quit".equals(input)) {
					break;
				}
				else {
					pw.println("message:" + input);
				}
			}

		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			// 10. 자원정리
			
			scanner.close();
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public static void log(String log) {
		System.out.println(log);
	}
}