package java_20190715;

public class LiteralDemo {
	public static void main(String[] args) {
		// byte 범위를 넘어가면 컴파일 에러 발생.
//		byte a1 = (byte)128;
		int a1 = 128;  //10진수 표기법
		int a2 = 076;  //8진수 표기법
		int a3 = 0xff;  //16진수 표기법
		// long literal은 숫자 뒤에 l, L을 표기해야 함.
		long a4 = 2200000000l;  
		// float literal은 소수점 뒤에 f, F로 표기해야 함.
		float f1 = 1234.43f;
		// double literal은 소수점 뒤에 d, D로 표기하거나 하지 않음. 
		double d1 = 123455.56d;
		// boolean literal은 true, false
		boolean isExisted = false;
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(f1);
		System.out.println(d1);
		System.out.println(isExisted);
		System.out.println("\n");
		
		a1 = 10;
		d1 = 10.0d;
		// primitive data type의 == 연산자는 값만 비교하는 비교연산자임 반환형은 상관없음.
		System.out.println(a1 == d1);
		System.out.println("\n");
		
		int b1 = 10;
		// b2에 b1의 값인 10을 할당함.
		int b2 = b1;
		b2 = 20;
		
		System.out.println(b1);
		System.out.println(b2);
	}
}