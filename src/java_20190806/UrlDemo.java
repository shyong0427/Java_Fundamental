package java_20190806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://sports.news.naver.com/worldfootballetc/news/read.nhn?oid=139&aid=0002115860#content");
		String protocol = url.getProtocol();
		String host = url.getHost();
		int port = url.getPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		System.out.println("protocol : " + protocol);
		System.out.println("host : " + host);
		System.out.println("port : " + port);
		System.out.println("path : " + path);
		System.out.println("query : " + query);
		System.out.println("ref : " + ref);
		
		InputStream is = url.openStream();
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