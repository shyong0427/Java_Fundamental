package java_20190729;

public class StringDemo {
	public static void main(String[] args) {
// 생성자 이용, 사용하지 않으면 garbage로 감 
		String s1 = new String("test");
		String s2 = new String("test");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
// "" 이용, 사용하지 않아도 유지됨
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));

		String ssn = "111111-11111118";
		char c = ssn.charAt(6);
		System.out.println(c);

		ssn = ssn.concat("abcd"); // ssn += ("abcd");
		System.out.println(ssn);

		String fileName = "abd.abc.abc.abc.dddddd.doc";
		if (fileName.endsWith("zip")) {
			System.out.println("압축파일 입니다.");
		} else if (fileName.endsWith("doc")) {
			System.out.println("워드문서 입니다.");
		} else {
			System.out.println("파일 입니다.");
		}
		System.out.println(fileName.equalsIgnoreCase("ABD.DOc"));
		
		int index = ssn.indexOf("-");
		System.out.println(index);
		
		System.out.println(fileName.indexOf("."));
		System.out.println(fileName.lastIndexOf("."));
// 111111-1111118 / first -이전  / second -이후  = -의 전과 후를 쪼갤 때 사용한다
		String first = fileName.substring(0, fileName.lastIndexOf(".")); //0번째자리부터 해당자리제외까지
		String second = fileName.substring(fileName.lastIndexOf(".")+1); //x를 포함한 자리의 수이후 
		System.out.println(first);
		System.out.println(second);
		
	}
}