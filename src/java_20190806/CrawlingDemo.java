package java_20190806;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {
	public static void main(String[] args) {
//		String url = "http://www.imbc.com";
//		//HTML 문서 전체를 관리하기 위한 객체
//		Document doc = null;
//		
//		try {
//			doc = Jsoup.connect(url).get();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Clear!");
//		
//		Elements elements = doc.select(".con-wrap.notice-wrap");
//		Elements noticeElements = elements.select("h3");
//		
//		String noticeTitle = noticeElements.text();
//		System.out.println(noticeTitle);
//		
//		Elements liElements = elements.select(".notice-list li");
//		for (int i = 0; i < liElements.size(); i++) {
//			Element liElement = liElements.get(i);
//			System.out.println(liElement.text());
//		}
		
		String url = "https://sports.news.naver.com/kfootball/index.nhn";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Clear!");
		
		Elements elements = doc.select(".home_news");
//		Elements homeElements = elements.select("h2");
//		
//		String homeTitle = homeElements.text();
//		System.out.println(homeTitle);
		
		Elements liElements = elements.select(".home_news_list li");
		for (int i = 0 ; i < liElements.size(); i++) {
			Element liElement = liElements.get(i);
			System.out.println(liElement.text());
		}
	}
}