package java_20190802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NaverCafeScaningDemo {
	public static void main(String[] args) throws IOException  {
		URL url = new URL("https://blog.naver.com/PostView.nhn?blogId=harloveysj&logNo=221460034406&redirect=Dlog&widgetTypeCall=true&directAccess=false");
		InputStream is = url.openStream();
		// 1. InputStream을 InputStreamReadr로 바꾼다.
		// 2. InputStreamReader을 BufferedReader로 바꾼다. (Stream Chaining)
		// 3. BufferedReader로 읽은 정보(html)를 "C:\\dev\\test\\navercafe.html" 파일로 저장한다.
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			fw = new FileWriter("C:\\dev\\test\\navercafe.html");
			bw = new BufferedWriter(fw);
			
			String readLine = null;

			while((readLine = br.readLine()) != null) {
				bw.write(readLine);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) is.close();
				if (isr != null) isr.close();
				if (br != null) br.close();
				if (fw != null) fw.close();
				if (bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}