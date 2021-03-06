package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static final int PORT = 7000;
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		try {
			// 1. socket 생성
			socket = new DatagramSocket(PORT);
			
			while (true) {
				// 2. 데이터 수신
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE); // byte 버퍼, 사이즈
				socket.receive(receivePacket); // blocking

				// 데이터가 오고 encoding
				byte[] data = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(data, 0, length,"UTF-8");

				System.out.println("[server] received:" + message);

				// 3. 데이터 송신
				byte[] sendData = message.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
						receivePacket.getPort()); // 배열, 길이, 주소
				socket.send(sendPacket);

			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

}
