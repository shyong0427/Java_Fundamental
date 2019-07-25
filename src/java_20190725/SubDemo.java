package java_20190725;

public class SubDemo {
	public static void main(String[] args) {
		Sub s1 = new Sub();
		s1.makeMoney();  // 부모의 메서드
		s1.gotoSchool();
		s1.play("starcraft");  // 부모의 메서드를 Overriding(재정의)
		s1.money = 1000000;
		s1.chicken = "교촌치킨2마리";
// 부모의 멤버변수, 메서드 접근 가능
// 자식의 멤버변수는 접근 불가, 메서드 접근 불가 
// 자식의 메서드 중에서 오버라이딩된 메서드 접근 가능
		Super s2 = new Sub();  // 객체의 형변환
		s2.makeMoney();
//		s2.gotoSchool();
// overriding된 것만 Sub의 것을 호출한다. 
		s2.play("starcraft");
		s2.money = 1000000;
//		s2.chicken = "교촌치킨2마리";
	}
}