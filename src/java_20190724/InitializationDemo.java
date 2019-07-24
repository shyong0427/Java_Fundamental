package java_20190724;
//i18n = 국제화(Internationalization)
//l10n = 지역화(Localization)
public class InitializationDemo {
	int a;
	static int b;
	static final int C = 10;
// static 변수 초기화 방법
	static {
		System.out.println("static area");
		b = 100;
	}
	
	{
		System.out.println("Instance area");
		a = 10;
	}
// 생성자에서 초기화 할 수 있는 변수는 instance변수 뿐이다. 
	public InitializationDemo(int a) {
		super();
		System.out.println("Consturctor");
		this.a = a;
	}
	
	public static void main(String[] args) {
		System.out.println("main area");
		InitializationDemo i = new InitializationDemo(1000);
		System.out.println(i.a);
		System.out.println(b);
		System.out.println(C);
	}

	
}