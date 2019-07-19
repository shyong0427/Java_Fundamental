package java_20190719;

//// public은 파일이름과 동일한 클래스에만 적용할 수 있다. 
public class A {
	String name;
	int age;
	
	public void m() {
		System.out.println("m() 메서드");
	}
	public static void main(String[] args) {
		A a = new A();
		a.name = "심헌용";
		a.age = 26;
		
		System.out.println(a.name);
		System.out.println(a.age);
		
		a.m();
	}
}

class B {
//// main 메서드가 실행되기 위해서는 pulic이 추가된 클래스에서만 작동된다.
//// file이름과 동일한 클래스에서 작동된다.
}