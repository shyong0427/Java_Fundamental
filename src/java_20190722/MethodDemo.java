package java_20190722;

public class MethodDemo {
//// 5 ~ 8Line 메서드 정의
//// boolean 메서드의 반환값
//// instance 메서드
//// int year : 매개변수 (parameter)
	public boolean isLeafYear(int year) { 
//// 메서드의 반환값이 boolean이기 때문에 return value의 value도 boolean이어야 한다.
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	public char charofString(String msg, int index) {
//// String msg = "hello";
		return msg.charAt(index);
	}
	
	public long plus(long first, long second) {
		return first + second;
	}
	
	public double divide(double first, double second) {
		return first / second;
	}
	
	public void ascending(int[] array) {
		for(int i=0;i<array.length;i++) {
			for (int j = 0; j < array.length-(i+1); j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MethodDemo m1 = new MethodDemo();
//// instance 메서드 사용방법
//// 객체 생성 후에 reference(m1)를 이용해서 호출하면 된다. 
//// (2000) : 전달인자(argument)
		boolean isLeafYear = m1.isLeafYear(2022);
		System.out.println(isLeafYear);
//// 객체 생성, method사용, 매개 변수 입력.		
		System.out.println(new MethodDemo().isLeafYear(2920));
//// "hello", 0 : 전달인자 (argument)
		char c = m1.charofString("hello", 0);
		System.out.println(c);
		
		long sum = m1.plus(2100000000, 2100000000);
		System.out.println(sum);
		
		double div = m1.divide(3, 0);
		System.out.println(div);
		
		int[] temp = {1, 2, 3, 4, 5, 41, 6, 25, 11};
		
		for (int a : temp) {
			System.out.print(a + "  ");
		}
		System.out.println();
		m1.ascending(temp); 
		for (int a : temp) {
			System.out.print(a + "  ");
		}
	}
}
