package java_20190807.echo.client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient2 {
	private String ip;
	private int port;

	public EchoClient2(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		Socket socket = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		InputStream is = null;
		FileOutputStream fos = null;

		try {
			// ip와 port로 서버와 접속을 시도한다.
			// 3. Socket을 생성한다.
			// 4. 서버와 연결한다.
			socket = new Socket(ip, port);
			// 6. 소켓으로 출력스트림을 생성한 한 후 서버에게 메세지를 보낸다.
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			// osw.write("Hello."); > 한줄로 아래와 같은 역할을 한다.
			bw.write("java-11.pdf");
			bw.newLine();
			bw.flush();

			is = socket.getInputStream();
			File f = new File("C:\\dev\\test\\network");
			f.mkdirs();
			f = new File(f, "java-11.pdf");
			fos = new FileOutputStream(f);
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			
			while((readByteCount = is.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}
		} catch (UnknownHostException e) {
			System.out.println("ServerAddress is Wrong.");
		} catch (IOException e) {
			System.out.println("Server is Shutdown.");
		} finally {
			try {
				if (os != null) os.close();
				if (osw != null) osw.close();
				if (bw != null) bw.close();
				if (is != null) is.close();
				if (fos != null) fos.close();
				if (socket != null) socket.close();
			} catch (IOException e2) {

			}
		}
	}

	public static void main(String[] args) {
		new EchoClient2("192.168.0.52", 4000).run();
	}
}