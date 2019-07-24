package java_20190724.aa;
// java_20190724.TestDemo.java와 연동
public class Test {
// compiler는 클래스내에 생성자가 없으면 자동으로 default생성자를 만든다.
// 이때 생성자의 접근 한정자는 클래스의 접근한정자를 따른다. 
	public static void main(String[] args) {
		System.out.println("hello");
	}
// Test1, Test2 클래스는 Test.java 파일안에서 선언은 가능하나 서로 다른 패키지에서 사용할 수 없다.
// Test1, Test2 클래스를 서로 다른 패키지에서 사용하려면 각각 별도의 파일을 만들어 접근한정자를 public으로 선언하여 사용한다.
	class Test1{
		
	}
	
	class Test2{
		
	}
}