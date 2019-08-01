package java_20190801;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("C:\\dev\\test\\jdk.exe");
			fos = new FileOutputStream("C:\\dev\\test\\2019\\08\\1\\jdk.exe");
			
			int readByteCount = 0;
			byte[] b = new byte[1024 * 40];
			// fis.read(b) => FileInputStream에 1024Byte를 읽어서 b에 저장하고 읽은 Byte수를 반환한다.
			long start = System.currentTimeMillis();
			
			while ((readByteCount = fis.read(b)) != -1){
				fos.write(b, 0, readByteCount);
			}
			long end = System.currentTimeMillis();
			System.out.println("경과시간 : " + (end - start));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}