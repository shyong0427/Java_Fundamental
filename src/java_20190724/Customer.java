package java_20190724;

import java.lang.*; // 평소에 생략되어있으며 'extends Object'는 상위 클래스(부모)가 없을 시 자동설정 되어있다.

public class Customer extends Object {
	String name, phone1, phone2, phone3;
	
	public Customer() {  
		super();  // 생성자 내에는 super();가 생략되어 있다.
	} // 평소 생성자가 생략되어 있다.
}