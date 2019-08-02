package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null;

		try {
			ps = System.out;  // monitor connect -> destination is monitor
			ps.println("Hello world!!!");
			/*
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java_pdf_clone.zip");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			ps = new PrintStream(bos, true);

			int readByte = 0;

			while ((readByte = bis.read()) != -1) {
//				bos.write(readByte);
				ps.write(readByte);
			}
//			bos.flush(); */
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
				if (bis != null) bis.close();
				if (ps != null) ps.close();
				if (bos != null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}