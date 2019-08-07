package java_20190807.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	private String ip;
	private int port;

	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		Socket socket = null;

		try {
			// ip와 port로 서버와 접속을 시도한다.
			// 3. Socket을 생성한다.
			// 4. 서버와 연결한다.
			socket = new Socket(ip, port);
			// 6. 소켓으로 출력스트림을 생성한 한 후 서버에게 메세지를 보낸다.
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			// osw.write("Hello."); > 한줄로 아래와 같은 역할을 한다.
			bw.write("Hello. \n");
			bw.newLine();
			bw.flush();
			// 9. 소켓으로 입력스트림을 생성한 후에 서버에서 보낸 메세지를 읽는다.
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String readLine = br.readLine();
			System.out.println(readLine);
		} catch (UnknownHostException e) {
			System.out.println("서버주소가 잘못되었습니다.");
		} catch (IOException e) {
			System.out.println("서버가 닫혀있습니다.");
		}
	}

	public static void main(String[] args) {
		new EchoClient("192.168.0.31", 3000).run();
	}
}