package java_20190716;

public class IfDemo {
	public static void main(String[] args) {
		//외부에서 값 받아오기, Integer.parseInt = 문자열을 int로 변환
		//Run Configurations - Argument - 입력
		int month = Integer.parseInt(args[0]);
//		System.out.println(month);
		
		String season = null;
		if (month == 12 || month == 1 || month == 2) {
			season = "겨울";
		} else if (month == 3 || month == 4 || month == 5) {
			season = "봄";
		} else if (month == 6 || month == 7 || month == 8) {
			season = "여름";
		} else if (month == 9 || month == 10 || month == 11) {
			season = "가을";
		} else {
			season = "없는 계절";
		} System.out.println(month + "월은 " + season + " 입니다.");
	}
}
/*

public class IfDemo {
	public static void main(String[] args) {
		int month = Integer.parseInt(args[0]);
		System.out.println(month);
		
		String season = null;
		
		if (month == 12 || month == 1 || month == 2) season = "겨울";
		else if (month >= 3 && month <= 5) season = "봄";
		else if (month >= 6 && month <= 8) season = "여름";
		else if (month >= 9 && month <= 11) season = "가을";
		else season = "없는 계절";
		System.out.println(month + "월은 " + season + " 입니다.");
	}
}*/