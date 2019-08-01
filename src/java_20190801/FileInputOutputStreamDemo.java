package java_20190801;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("C:\\dev\\test\\jdk.exe");
//			File f1 = new File("C:\\dev\\test\\2019\\08\\1");
//			boolean isExisted = f1.isDirectory();
//			if (!isExisted) {
//				f1.mkdirs(); 
//			}
			FileDemo f = new FileDemo();
			f.mkdirs("C:\\dev\\test\\2019\\08\\01");
			// FileOutputStream(String path) 생성자에서 FileNotFoundException의 의미는 경로가 없기 때문에
			// 발생한다.
			// 따라서 FileOutputStream 객체를 생성할 때는 경로가 있는지 체크한 후 객체를 생성해야 한다.
			fos = new FileOutputStream("C:\\dev\\test\\2019\\08\\01\\jdk.exe");

			int readByte = 0;
			// fis.read() 메서드는 한 바이트 읽어 반환한다.
			// 만약 더 이상 읽을 바이트가 없으면 -1을 반환한다.
			while ((readByte = fis.read()) != -1) {
				// fos.write(readByte)는 한 바이트 쓰기
				fos.write(readByte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}

				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}