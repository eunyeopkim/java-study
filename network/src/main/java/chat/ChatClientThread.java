package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatClientThread extends Thread {

	private Socket socket;

	List<Writer> listWriters;

	public ChatClientThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run(){
		// reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리)
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			while (true) {
				String data = br.readLine();
				if (data == null) {
					ChatClient.log("closed by server");
					break;
				}
				ChatClient.log(data);
			}

		} catch (IOException e) {
			ChatClient.log("closed by client");

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

}
