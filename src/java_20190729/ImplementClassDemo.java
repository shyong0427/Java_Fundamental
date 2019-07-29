package java_20190729;

public class ImplementClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 추상클래스는 객체 생성이 불가하며, 상속을 해야 한다.
		InterA i = new ImplementClass();
		i.mA();	i.mB();	i.mC();
// 변경 불가!
//		PI = 3.15;
		System.out.println(InterA.PI);
	}
}