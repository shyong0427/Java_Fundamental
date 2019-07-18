//특수문자 중 $,_는 사용할 수 있다.
package java_20190715;
//클래스 첫 글자는 대문자 사용
//두 단어가 합쳐질 경우에는 두 번쨰 단어의 첫 글자는 대문자 사용 (Camel-case)
public class IdentifierDemo {
	public static void main(String[] args) {
		int age = 10;
		String name = "Hello";
		
/*
//첫 글자 숫자 사용 불가
		String 1fatherName = "John";
//공백 사용 불가
		String mother Name = "Michell";
//예약어는 식별자로  사용불가
		String void = "empty";
*/
		
		//자바는 유니코드를 지원하기 때문에 한글도 식별자로 사용가능하다.
		String 이름 = "심헌용";
		System.out.println(이름);
	}
}