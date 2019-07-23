package java_20190723;

public class AdminDemo {
	public static void main(String[] args) {
		Admin a = new Admin("shyong0427", "1111", "shyong0427@daum.net", 1);  //default값으로 초기화
//		a.setId("shyong0427");
//		a.setPwd("0000");
//		a.setEmail("shyong0427@daum.net");
//		a.setLevel(1);
		System.out.printf("%s, %s, %s, %d \n", a.getId(), a.getPwd(), a.getEmail(), a.getLevel());
	}
}