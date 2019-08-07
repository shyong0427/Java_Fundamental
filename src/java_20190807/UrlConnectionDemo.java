package java_20190807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

// URL class는 내용만 가져온다. 
// URLConnetion class는 header정보를 가져올 수 있다.
public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://sports.news.naver.com/wbaseball/index.nhn");
		URLConnection urlCon = url.openConnection();
//		cache-control: no-store
//		content-type: text/html;charset=UTF-8
		String catheControl = urlCon.getHeaderField("cache-control");	
		String contentType = urlCon.getHeaderField("content-type");
		String date = urlCon.getHeaderField("date");
		System.out.println("catheControl : " + catheControl);
		System.out.println("contentType : " + contentType);
		System.out.println("date : " + date);
		
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String readLine = null;
		
		while((readLine = br.readLine()) != null) {
			System.out.println(readLine);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}