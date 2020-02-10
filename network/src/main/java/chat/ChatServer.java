package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
	private static final int PORT = 9998;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			serverSocket = new ServerSocket();

			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결 기다림 " + hostAddress + ":" + PORT);

			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters, map).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String log) {
		System.out.println("[server#" + Thread.currentThread().getId() + "]" + log);

	}

}
