package java_20190715;

public class CharLiteralDemo {
	public static void main(String[] args) {
		// char literal의 유니코프 표현 = '\u0000'
		char c1 = '\uc2ec';
		char c2 = '\ud5cc';
		char c3 = '\uc6a9';
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println("\n");	
		// char literal의 아스키코드 표현 = 65
		char c4 = 65;
		
		System.out.println(c4);
		System.out.println("\n");		
		// char literal의 문자표현 = 'a'
		char c5 = 'q';
		
		System.out.println(c5);
		System.out.println("\n");
		
		char c6 = '\"';
		// \n = Line Feed (개행
		// \t = Tab만큼 공간이동
		// \\ = Back Slash
		// \' = Single Quotation
		// \" = Double Quotation
		String path = "aa\ncc";
		
		System.out.println(c6);
		System.out.println(path);
	}
}