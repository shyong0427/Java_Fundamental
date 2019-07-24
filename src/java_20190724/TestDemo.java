package java_20190724;
// Test 클래스를 import해서 사용하기 위해서는 Test 클래스의 접근한정자는 public이어야 한다. 
import java_20190724.aa.Test;

public class TestDemo {
	public static void main(String[] args) {
		Test t = new Test(); // 객체 생성, 생성자 1:1 대응
	}
}