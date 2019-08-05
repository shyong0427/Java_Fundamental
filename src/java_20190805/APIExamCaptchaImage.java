package java_20190805;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class APIExamCaptchaImage {
    public static void main(String[] args) {
        String clientId = "ENGh6nYoorK8lefcfutw";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "Z6JOfEQtax";//애플리케이션 클라이언트 시크릿값";
        try {
            String key = "JGKNQEpRTepPhvZY"; // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
            String apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 파일 생성
//              String tempname = Long.valueOf(new Date().getTime()).toString(); //getTime() : 시간측정
                String tempname = String.valueOf(new Date().getTime()); // long type -> String type 
                String path = "C:\\dev\\test"; // 환경에 맞게 경로를 수정
//              File f = new File("tempname + ".jpg");
                File f = new File(path, 	tempname + ".jpg"); // 위의 코드 수정 
                f.createNewFile();
                OutputStream outputStream = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
