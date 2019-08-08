package java_20190808.file.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	private int port;
	
	public FileServer(int port) {
		this.port = port;
	}
	
	public void run() {
		ServerSocket serverSocket = null;
		FileServerThread fst = null;
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (true) {
			System.out.println("Waiting for Client...");
			
			try {
				Socket socket = serverSocket.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("Client Connected. [ip : " + ip + "]");
				
				fst = new FileServerThread(socket);
				Thread t = new Thread(fst);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static void main(String[] args) {
		new FileServer(4000).run();
	}
}