package java_20190808.unicast.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UnicastServerThread implements Runnable {
	private Socket socket;
	
	public UnicastServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			boolean isStop = false;
			
			while (!isStop) {
				// 정상메세지 -> id : message
				// 종료메세지 -> shutdown				
				String readLine = br.readLine();
				System.out.println(readLine);
				
				if (readLine.equals("Shutdown")) {
					bw.write("Shutdown \n");
					bw.flush();
					isStop = true;
				} else {
					bw.write(readLine + "\n");
					bw.flush();
				}
			}
		} catch (IOException e) {
			System.out.println("비정상적으로 종료하셨습니다.");
		} finally {
			try {
				if (bw != null) bw.close();
				if (br != null) br.close();
			} catch (IOException e2) {
				
			}
		}
	}
}