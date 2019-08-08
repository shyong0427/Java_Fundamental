package java_20190808.file.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread implements Runnable {
	private Socket socket;

	public FileServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InputStream is = null;
		OutputStream os = null;
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String fileName = br.readLine();
			System.out.println("File Request From Client : " + fileName);
			
			fis = new FileInputStream("C:\\dev\\test\\" + fileName);
			os = socket.getOutputStream();
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			
			while ((readByteCount = fis.read(readBytes)) != -1) {
				os.write(readBytes, 0, readByteCount);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
				if (isr != null) isr.close();
				if (br != null) br.close();
				if (os != null) os.close();
				if (fis != null) fis.close();
				if (socket != null) socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
