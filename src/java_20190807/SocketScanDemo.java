package java_20190807;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketScanDemo {
	public static void main(String[] args) {
		Socket socket = null;
		
		for (int i = 1; i < 1024; i++) {
			// Socket 객체가 생성되었다는 것은 Host, Port로 통신할 수 있다는 것이고 해당 Host에 Port번호를 사용하고 있다는 것이다.
			try {
				socket = new Socket("211.119.250.80", i);
				System.out.println(i + "번호를 사용하고 있습니다.");
			} catch (UnknownHostException e) { // 호스트 문제시 발생
				System.out.println("호스트가 존재하지 않습니다.");
			} catch (IOException e) { // 포트를 사용하고 있을 시 발생
				System.out.println(i + "번호를 사용하지 않고 있습니다.");
			}
		}
	}
}