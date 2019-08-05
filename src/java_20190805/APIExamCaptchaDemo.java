package java_20190805;

import java.util.Calendar;
import java.util.Scanner;

import Bonus.Utility;

public class APIExamCaptchaDemo {
	public static String console(String msg) {
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	public static void main(String[] args) {
		String id = "ENGh6nYoorK8lefcfutw", secret = "Z6JOfEQtax";
		String key = Utility.getCaptchaKey(id, secret);
		boolean isSuccess = Utility.isCaptchaImage(id, secret, key);
		
		if (isSuccess) {
			String value = console("이미지 결과 값을 입력하세요 > ");
			boolean result = Utility.isCaptchaResult(id, secret, key, value);
			System.out.println(result);
			if (result) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} else {
			System.out.println("다시 확인하시오.");
		}
		
		
		System.out.println(key);
//		Calendar c = Calendar.getInstance();
//		System.out.println(Utility.getDate(c, "yyyy/MM/dd"));
	}
}