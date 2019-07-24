package java_20190724;

public class Box {
	int width, height, depth;  // instance variable - 초기화 O
// final 변수는 멤버변수 위치에서 초기화해야 하며 변경이 불가하다.
// 변수의 특성상 인스턴스 변수로 처리하지 않고 static변수로 처리한다. 
	static final String NAME = "shy";
	
	public void change(Box b) {
// local variable(매개변수 포함) - 초기화 X
// 메서드내에서 매개변수를 포함한 사용자가 정의한 변수를 지역변수라 한다.
// 지역변수는 자동초기화가 되지 않기 때문에 기본값을 저장하고 사용한다.
// 지역변수의 유효범위는 메서드 내이다. 
		int a = 0;
		String str = null;
		double d = 0.0;
		int c = width + 4;
		
		System.out.println(width);
		depth = 3000;
	}
}