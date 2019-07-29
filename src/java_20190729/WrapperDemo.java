package java_20190729;
// Ctrl + Shift + O : Auto import
import java.util.ArrayList;

public class WrapperDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
// Java ver1.4 이전에는 primitive data type(pdt)을 Collection에 저장할 수 없었기 때문에 pdt을 객체화 할 수 있는 Wrapper으로 변환하여 저장해야 한다.
// list.add(1); 와 같이 1을 add 할 수 없다. 
		list.add(new Integer(1));
// 1. primitive data type -> wrapper class(생성자 이용 : new Integer(10))
		Integer i2 = new Integer(10); // Collection에 담기 위해서, auto-boxing
		Integer i3 = new Integer(20);
// 2. String -> wrapper class(Integer.valueOf("10"))
		String s1 = "10";
		String s2 = "20";
		Integer i1 = Integer.valueOf(s1);
// 3. wrapper class -> primitive data type(intValue()) 연산하기 위해서
		int temp = i2.intValue() + i3.intValue(); //auto-unboxing
// 4. String -> primitive data type(Integer.parseInt("10"))
		temp = Integer.parseInt(s1) + Integer.parseInt(s2);
// 5. primitive data type -> String(+" ")
		int a1 = 10; // int to String
//		String s3 = a1 + "";
		String s3 = String.valueOf(a1);
		//auto boxing : primitive data type을 자동으로 wrapper로 변경
		Integer i4 = 10;
		//auto unboixng : warpper를 자동으로 primitive data type으로 변경
		int a2 = i2 + i3;
		
		System.out.println(i2);
		System.out.println(i2.equals(i3));
		
		String s4 = "12.34";
		double d1 = Double.parseDouble(s4);
		System.out.println(d1);
	}
}