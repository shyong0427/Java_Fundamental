package java_20190724;

public class BoxDemo {
	int a;
	static int b;
	public static void main(String[] args) {
		String temp = args[0];
//		a = 10;
// static에서 instance변수 사용하는 방법 (객채 생성 후 사용한다.)
		BoxDemo bb1 = new BoxDemo();
		bb1.a = 10;
// static의 변수는 그냥 접근이 가능하지만 아래와 같이 사용하는 것을 선호한다.
		BoxDemo.b = 20;
//		Box.NAME = "Box";

		Box b1 = new Box();
		b1.width = 10;
		b1.height = 20;
		b1.depth = 30;
		System.out.printf("width : %d, height : %d, depth : %d \n", b1.width, b1.height, b1.depth);

		Box b2 = new Box();
		b2.width = 10;
		b2.height = 20;
		b2.depth = 30;
// instance의 '=='은 값 비교, reference의 '==' 각 각의 참조점이 같은 지를(같은 object를 참조하는지) 비교한다. 같으면 true, 같지 않으면 false
		System.out.println(b1 == b2);

		Box b3 = b2;
		System.out.println(b2 == b3);

		b1.change(b1); // call by reference
		System.out.printf("width : %d, height : %d, depth : %d \n", b1.width, b1.height, b1.depth);
	}
}