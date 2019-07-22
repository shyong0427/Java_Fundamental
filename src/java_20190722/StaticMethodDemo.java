package java_20190722;

public class StaticMethodDemo {
	String name;
	static double interestRate;
	
	public void m1() {
		System.out.println("m1() 메서드 호출");
	}
	
	public void m2() {
//// instance method에서는 instance 변수, static 변수 모두 사용가능하다.
//// instance 메서드 static 메서드 호출 가능하다.
		this.name = "심헌용";
		StaticMethodDemo.interestRate = 0.1;
		this.m1();
		StaticMethodDemo.m3();
	}
	
	public static void m3() {
		System.out.println("m3() 메서드 호출");
	}
	
	public static void m4() {
//// static method에서는 instance 변수 사용 불가하며 static 변수만 사용 가능하다.
//// instance 메서드 호출 불가하며 static 메서드는 호출 가능하다.
//// this문을 사용할 수 없다.
//		name = "홍길동";
		interestRate = 0.2;
//		m1();
		m3();
	}	
	
	public static void main(String[] args) {
		StaticMethodDemo.m3();
		StaticMethodDemo.m4();
		StaticMethodDemo.interestRate = 1.4;
		
		StaticMethodDemo s1 = new StaticMethodDemo();
		s1.m1	();
		s1.m2();
		s1.name = "T^T";		
	}
}