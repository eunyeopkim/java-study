package chat.client.win;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER = "0.0.0.0";
	private static final int PORT = 9998;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();

			if (name.isEmpty() == false) {
				break;
			}


			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}

		scanner.close();

		// 1. socket 생성
		Socket socket = new Socket();
		try {
			// 2. connect to server
			socket.connect(new InetSocketAddress(SERVER, PORT));
			log("connected");
			new ChatWindow(name, socket).show();
			// 3. IOStream 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			// 4. join 프로토콜 요청
			String request = "join:" + name + "\r\n";
			pw.println(request);
			// 5. join 프로토콜이 성공 응답을 받으면
			// new ChatWindow(name, socket).show();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				if (socket != null && !socket.isClosed()) {
//					socket.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

	}

	public static void log(String log) {
		System.out.println("[client]" + log);
	}

}
