package java_20190722;

import java_20190719.Customer;

public class CustomerStaticDemo {
	public static void main(String[] args) {

		Customer.interestRate = 3.5;
		
		Customer c1 = new Customer();
		c1.name = "심헌용";
		c1.age = 26;
		c1.email = "shyong0427@daum.net";
		c1.phone = "010-3185-5215";
		c1.balance = 328_651_223.234;
		c1.isReleased = false;
//// final 변수는 재할당이 불가하다.
//		c1.BANKNAME = "국민은행";
//		c1.interestRate = 3.5;
//// static의 변수명은 클래스 이름으로 접근하는 것이 관례지만 reference로도 접근이 가능하다(권장하지 않음). 
//		Customer.interestRate = 3.5;

		Customer c2 = new Customer();
		c2.name = "손정의";
		c2.age = 60;
		c2.email = "ceo@softbank.co.kr";
		c2.phone = "010-9999-0000";
		c2.balance = 45_000_000_000.244;
		c2.isReleased = true;
		
		System.out.println(Customer.interestRate);
		
		Customer c3 = new Customer();
		c3.name = "배조스";
		c3.age = 62;
		c3.email = "jaws@amazon.com";
		c3.phone = "010-1111-1111";
		c3.balance = 12000000.45;
		c3.isReleased = false;
	}
}