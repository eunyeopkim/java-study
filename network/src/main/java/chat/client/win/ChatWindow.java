package chat.client.win;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import chat.ChatServerThread;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;
		new ChatClientThread(socket).start();
	}

	public void show() {
		// 1. UI 초기화 (신경x)

		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				// key를 눌렀다뗐을떄
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		// 2. IOStream 초기화
		
		// 3. Thread 생성작업
		
	}

	private void sendMessage() {
		PrintWriter pw;

		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			String msg = textField.getText();
			if ("quit".equals(msg)) {
				pw.println("quit");
				System.exit(0);
			} else if (msg.startsWith("to:") || msg.startsWith("ban:")) {
				pw.println(msg);
			} else {
				pw.println("message:" + msg);
			}
//         textArea.append("둘리:"+msg);      //예시코드
//         textArea.append("\n");   
			textField.setText("");
			textField.requestFocus();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public class ChatClientThread extends Thread {
		private Socket socket = null;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			// msg는 소켓에서 읽음
			try {
				BufferedReader br = new BufferedReader(
						new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
				while (true) {
					String msg = br.readLine();
					if (msg == null) {
						textArea.append(" ");
					}
					if ("ban".equals(msg)) {
						System.out.println("접속이 종료되었습니다.");
						System.exit(0);
					}
					textArea.append(msg);
					textArea.append("\n");

				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}