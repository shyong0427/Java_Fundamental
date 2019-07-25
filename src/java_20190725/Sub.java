package java_20190725;

public class Sub extends Super {
	String chicken;
	
	public void gotoSchool() {
		System.out.println("Sub gotoSchool()");
	}
// Overriding : 부모의 메서드 재정의 
// 1. 반환형, 메서드이름, 매개변수 반드시 일치
// 2. 접근한정자는 부모보다 자식이 상위이거나 같으면 됨.
	public void play(String starcraft) {
// Super의 기능과 Sub의 기능 모두 사용하고자 할 때.
		super.play("omok");
		System.out.println("Sub Play()");
	}
}