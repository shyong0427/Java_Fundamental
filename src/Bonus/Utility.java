package Bonus;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Utility {
	// pattern => "yyyy-MM-dd a hh:mm:ss E요일
	// yyyy : 년도, MM : 월, dd : 일, a : 오전,오후, hh : 시간, mm : 분, ss : 초, E : 요일
	// Utility.getDate(c, "yyyy"); > 사용방법
	public static String getDate(Calendar c, String pattern) {
		return new SimpleDateFormat(pattern).format(c.getTime());
//		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//		String date = sdf.format(c.getTime());
//		System.out.println(date);
//		return date;
	}

	public static boolean mkdirs(String path) {
		boolean isSuccess = false;
		File file = new File(path);
		boolean isExisted = file.isDirectory();

		if (!isExisted) {
			isSuccess = file.mkdirs();
		}

		return isSuccess;
	}

	public static String getComma(long name) {
		return String.format("%,d", name);
	}

	public static String getComma(double name, int precision) {
		return String.format("%,." + precision + "f", name);
	}

	public static boolean changeFile(String path) {
		boolean isSuccess = false;
		File oldFile = new File(path);
		String fileName = oldFile.getName();
		String name = fileName.substring(0, fileName.lastIndexOf("."));
		String extensionWithDot = fileName.substring(fileName.lastIndexOf("."));
		// 이 부분이 마음에 안들면 아래 부분을 수정하세요.
		name = String.valueOf(System.currentTimeMillis());
		fileName = name + extensionWithDot;

		String parent = oldFile.getParent();
		File newFile = new File(parent, fileName);
		isSuccess = oldFile.renameTo(newFile);

		return isSuccess;
	}

	public static String getShortenURL(String id, String secret, String oriURL) {
		String clientId = id;// 애플리케이션 클라이언트 아이디값";
		String clientSecret = secret;// 애플리케이션 클라이언트 시크릿값";
		StringBuffer response = new StringBuffer();
		try {
			String text = oriURL;
			String apiURL = "https://openapi.naver.com/v1/util/shorturl?url=" + text;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine + "\n");
			}
			br.close();
//			System.out.println(response.toString());
			
			JSONParser jsonParse = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParse.parse(response.toString());
			JSONObject dataObject = (JSONObject) jsonObj.get("result");
			response.setLength(0);
			response.append(dataObject.get("url"));
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return response.toString();
	}
	
	public static String getCaptchaKey(String id, String secret) {
		String key = null;
		String clientId = id;//애플리케이션 클라이언트 아이디값";
        String clientSecret = secret;//애플리케이션 클라이언트 시크릿값";
        try {
            String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
//            System.out.println(response.toString());
            
			JSONParser jsonParse = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParse.parse(response.toString());
			key = (String) jsonObj.get("key");
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return key;
	}
	
	public static boolean isCaptchaImage(String id, String secret, String key) {
		boolean isSuccess = false;
		String clientId = id;//애플리케이션 클라이언트 아이디값";
        String clientSecret = secret;//애플리케이션 클라이언트 시크릿값";
        try {
//          String key = key; // https://openapi.naver.com/v1/captcha/nkey 호출로 받은 키값
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
                Calendar c = Calendar.getInstance();
                File file = new File(path, Utility.getDate(c, "yyyy\\MM\\dd"));
                Utility.mkdirs(file.getPath());
                File f = new File(file, tempname + ".jpg"); // 위의 코드 수정 
//                f.createNewFile();
                OutputStream fos = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    fos.write(bytes, 0, read);
                }//outputStream
                is.close();
                isSuccess = true;
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
		
		return isSuccess;
	}
	
	public static boolean isCaptchaResult(String id, String secret, String key, String value) {
		boolean result = false;		
		String clientId = id;//애플리케이션 클라이언트 아이디값";
        String clientSecret = secret;//애플리케이션 클라이언트 시크릿값";
        try {
            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
//          String key = "JGKNQEpRTepPhvZY"; // 캡차 키 발급시 받은 키값
//          String value = "36789SX"; // 사용자가 입력한 캡차 이미지 글자값
            String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code +"&key="+ key + "&value="+ value;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
//            System.out.println(response.toString());
            
        	JSONParser jsonParse = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParse.parse(response.toString());
//			왼쪽 boolean, 오른쪽 Boolean  =>  wrapper class => primitive class
			result = (Boolean) jsonObj.get("result"); // auto-unboxing
//			response.setLength(0);
//			response.append(result);
//			System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return result;
	}

	public static boolean isQrcode(String content, int width, int height) {
		boolean isSuccess = false;
		QRCodeWriter writer = new QRCodeWriter();
		try {
			BitMatrix qrCode = writer.encode(content, BarcodeFormat.QR_CODE, width, height);
			BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(qrCode);
			File f = new File("C:\\dev\\test\\qrcode.png");
			isSuccess = ImageIO.write(qrImage, "PNG", f);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}

}