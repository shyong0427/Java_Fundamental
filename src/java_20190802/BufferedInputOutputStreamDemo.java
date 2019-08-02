package java_20190802;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {/*
* 1. FileInputStream과 FileOutputStream을 이용하여 1Byte읽어서 1Byte출력한 예제이고, 경과 시간은 약 13초이다.
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java_pdf_copy.zip");
			
			int readByte = 0;
			long start = System.currentTimeMillis();
			while ((readByte = fis.read()) != -1){
				fos.write(readByte);
			}
			long end = System.currentTimeMillis();

			System.out.printf("경과시간 : %d \n", (end - start));
			*/
			
			/*
* 2. BufferedInputStream과 BufferedOutputStream을 이용하여 1Byte를 읽어서 1Byte를 출력한 예제이고 경과시간은 0.02초이다.
*    BufferedInputStream의 read()메서드는 1Byte읽어서 BufferedInputStream의 Buffer(byte[])공간에 저장한다. 
*    BufferedOutputStream의 write()메서드는 1Byte출력하는 것이 아니라 BufferedOutputStream의 Buffer(byte[])공간에 가득 차 있으면 출력한다.
*    만약 다 채워지지 않으면 출력하지 않으며, 이런 경우 flush()메서드를 이용하여 출력해야 한다.
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java_pdf_copy.zip");
			bis = new BufferedInputStream(fis); // Stream Chaining
			bos = new BufferedOutputStream(fos); // Stream Chaining
			
			int readByte = 0;
			long start = System.currentTimeMillis();
			while ((readByte = bis.read()) != -1){
				bos.write(readByte);
			}
			// BufferedOutputStream의 Buffer(byte[])는 다 채워지면 자동으로 전송하지만 다 채워지지 않으면 전송하지 않는다.
			// 따라서 다 채워지지 않더라도 버퍼를 비우기 위해서는 flush() 메서드를 사용해야 한다.
			bos.flush(); // 반드시 해야한다. 
			long end = System.currentTimeMillis();

			System.out.printf("경과시간 : %d \n", (end - start));
		*/
			
			
			/*
// 사용자제 : 약 0.015초 경과 -> 2번과 속도가 별반 다르지 않다.
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java_pdf_copy.zip");
			bis = new BufferedInputStream(fis); // Stream Chaining
			bos = new BufferedOutputStream(fos); // Stream Chaining
			
			int readByteCount = 0;
			byte[] readBytes = new byte[8192];
			long start = System.currentTimeMillis();
			while ((readByteCount = bis.read(readBytes)) != -1){
				bos.write(readBytes, 0, readByteCount);
			}
			// BufferedOutputStream의 Buffer(byte[])는 다 채워지면 자동으로 전송하지만 다 채워지지 않으면 전송하지 않는다.
			// 따라서 다 채워지지 않더라도 버퍼를 비우기 위해서는 flush() 메서드를 사용해야 한다.
			bos.flush(); // 반드시 해야한다. 
			long end = System.currentTimeMillis();

			System.out.printf("경과시간 : %d \n", (end - start));
			 */
			
			
//* 3. FileInputStream과 FileOutputStream을 이용하여 8192Byte읽어서 8192Byte출력한 예제이고 경과 시간은 약 0.002초이다. 
			fis = new FileInputStream("C:\\dev\\test\\java_pdf.zip");
			fos = new FileOutputStream("C:\\dev\\test\\java_pdf_copy.zip");
			
			int readByteCount = 0;
			byte[] readBytes = new byte[8192];
			long start = System.currentTimeMillis();
			while ((readByteCount = fis.read(readBytes)) != -1){
				fos.write(readBytes, 0, readByteCount);
			}
			long end = System.currentTimeMillis();

			System.out.printf("경과시간 : %d \n", (end - start));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
				if (bis != null) bis.close();
				if (bos != null) bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}