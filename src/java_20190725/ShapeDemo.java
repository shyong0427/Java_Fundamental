package java_20190725;

public class ShapeDemo {
	public static void main(String[] args) {
// 추상클래스는 객체를 생성할 수 없다.
//		Shape s = new Shape();
		
		Shape s1 = new Rectangle();
		s1.draw();
		
		Shape s2 = new Circle();
		s2.draw();
	}
}