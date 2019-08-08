package java_20190808.multicast.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java_20190808.multicast.server.MulticastServerThread;

public class MulticastClient implements ActionListener {
	private String id, ip;
	private int port;
	private JFrame jframe;
	private JTextArea jta;
	private JTextField jtf;
	private JButton jbtn;
	private BufferedReader br;
	private BufferedWriter bw;

	public MulticastClient(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;

		jframe = new JFrame("Unicast Chatting");
		/***** 중앙 *****/
		jta = new JTextArea("", 50, 30);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setBackground(new Color(255, 255, 204));
		/***** 중앙 *****/

		/***** 하단 *****/
		jtf = new JTextField(30);
		jbtn = new JButton("SEND");
		jtf.setBackground(new Color(202, 202, 203));
		
		JPanel j1 = new JPanel();
		j1.setLayout(new BorderLayout());
		j1.add(jtf, BorderLayout.CENTER);
		j1.add(jbtn, BorderLayout.EAST);
		/***** 하단 *****/

		/***** 상단 *****/
		JPanel j2 = new JPanel();
		JLabel jl1 = new JLabel("User ID : [" + id + "]");
		j2.setBackground(Color.ORANGE);
		JLabel jl2 = new JLabel("Server IP : " + ip);
		j2.setLayout(new BorderLayout());
		j2.add(jl1, BorderLayout.CENTER);
		j2.add(jl2, BorderLayout.EAST);
		/***** 상단 *****/

		jframe.add(jsp, BorderLayout.CENTER);
		jframe.add(j1, BorderLayout.SOUTH);
		jframe.add(j2, BorderLayout.NORTH);
		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);

		// X(종료)를 눌렀을 때 프로그램을 종료하기 위한 코드
		jframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
				try {
					bw.write("Shutdown \n");
					bw.flush();
//					String readLine = br.readLine();
					
//					if (readLine.equals("Shutdown")) {
//						close();
//						System.exit(0);
//					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			public void windowOpened(WindowEvent e) {
				jtf.requestFocus();
			}
		});
		// 이벤트 등록
		jbtn.addActionListener(this);
		jtf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == jtf) {
			// 텍스트 필드가 가져오기
			String message = jtf.getText();

			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "Do not enter only Enter.", "WARNING", JOptionPane.ERROR_MESSAGE);
			} else {
				// 텍스트 에어리어에 추가하기
				try {
					bw.write(id + " : " + message + "\n");
					bw.flush();

					String readLine = br.readLine();
					jta.append(readLine + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			// 텍스트 필드에 입력된 값 제거하기
			jtf.setText("");
		} else if (obj == jbtn) {
			// 텍스트 필드가 가져오기
			String message = jtf.getText();

			if (message.trim().length() == 0) {
				JOptionPane.showMessageDialog(jframe, "Do not enter only Enter.", "WARNING", JOptionPane.ERROR_MESSAGE);
			} else {
				// 텍스트 에어리어에 추가하기
				try {
					bw.write(id + " : " + message + "\n");
					bw.flush();
//					String readLine = br.readLine();
//					jta.append(readLine + "\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			// 텍스트 필드에 입력된 값 제거하기
			jtf.setText("");
			jtf.requestFocus();
		}
	}
	
	private void close() {
		try { 
			if (bw != null) bw.close();
			if (br != null) br.close();
		} catch (IOException e2) {
		}
	}

	public void connect() {
		try {
			Socket socket = new Socket(ip, port);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			MulticastClientThread mct = new MulticastClientThread(br, jta);
			Thread t1 = new Thread(mct);
			t1.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MulticastClient("030", "192.168.0.52", 6000).connect();
	}
}