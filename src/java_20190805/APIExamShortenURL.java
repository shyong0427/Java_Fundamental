package java_20190805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Bonus.Utility;

public class APIExamShortenURL {

    public static void main(String[] args) {
        String clientId = "IhTVcehWG3YYeg5kiH8H";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "YV9g0ApiTS";//애플리케이션 클라이언트 시크릿값";
        String oriURL = "https://docs.google.com/spreadsheets/d/1AEbbhYgDMouucbzE4OOxLUXoYLMr2nNyWqE4wq3rTeU/edit#gid=1520357372";
        String url = Utility.getShortenURL(clientId, clientSecret, oriURL);
//      System.out.println(url);
        
        if (Utility.isQrcode(url, 300, 300)) {
        	System.out.println("QR-code 생성 성공");
        } else {
        	System.out.println("QR-code 생성 실패");
        }
        
    }
}