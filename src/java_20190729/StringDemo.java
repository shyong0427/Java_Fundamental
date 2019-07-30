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
// charAt(int index) : 문자열중에서 특정 index에 있는 문자을 반환한다.
// 시작 index는 0번째 자리부터이다.
		char c = ssn.charAt(6);
		System.out.println(c);
// concat(String msg) : 문자열 연결
		ssn = ssn.concat("abcd"); // ssn += ("abcd"); -> 최대한 사용자제할 것.
		System.out.println(ssn);

		String fileName = "abd.abc.abc.abc.dddddd.doc";
// endsWith(String msg) : msg문자열로 끝나면 true, 그렇지 않으면 false를 반환한다.
		if (fileName.endsWith("zip")) {
			System.out.println("압축파일 입니다.");
		} else if (fileName.endsWith("doc")) {
			System.out.println("워드문서 입니다.");
		} else {
			System.out.println("파일 입니다.");
		}
// equalsIgnoreCase(String msg) : 대소문자를 구분하지 않고 문자열을 비교하여 같으면 true, 그렇지 않으면 false를 반환한다.
		System.out.println(fileName.equalsIgnoreCase("ABD.DOc"));
// indexOf(String msg) : msg문자열 위치를 반환한다. msg문자열을 처음부터 찾고 index는 처음부터 0번째부터 시작이다.
		int index = ssn.indexOf("-");
		System.out.println(index);
		
		System.out.println(fileName.indexOf("."));
// lastIndexOf(String msg) : msg문자열 위치를 반환한다. msg문자열을 찾을 때 끝부터 찾고 index는 처음부터 시작한다.
		System.out.println(fileName.lastIndexOf("."));
// 111111-1111118 / first -이전  / second -이후  = -의 전과 후를 쪼갤 때 사용한다
// substring(int first, int second) : first(포함), second(포함하지 않음) 사이의 문자열을 추출한다. 
// substring(int first) : first(포함)보다 큰 모든 문자열을 추출한다.
		String first = fileName.substring(0, fileName.lastIndexOf(".")); //0번째자리부터 해당자리제외까지
		String second = fileName.substring(fileName.lastIndexOf(".")+1); //x를 포함한 자리의 수이후 
		System.out.println(first);
		System.out.println(second);
		
		String html = "안녕하세요 \n 저는 ㅌㅌㅌ 입니다. \n잘 부탁드립니다.";
// replaceAll(String first, String second) : first문자열을 second문자열로 대체한다.
		html = html.replaceAll("\n", "<br>");
		System.out.println(html);
		
		String url = "http://www.naver.com";
		String path = "/news";
// startWith(String msg) : msg문자열로 시작하면 true, 그렇지 않으면 false
		if (path.startsWith("/news")) {
			System.out.println("뉴스 페이지입니다.");
		} else if (path.startsWith("/sports")) {
			System.out.println("스포츠 페이지입니다");
		} else {
			System.out.println("페이지가 존재하지 않습니다.");
		}
		
		String m1 = "hello";
		String m2 = "hello ";
		if (m1.equals(m2.trim())) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
// toUpperCase() : 대문자로 변환
		m1 = m1.toUpperCase();
		System.out.println(m1);
// toLowerCase() : 소문자로 변환	
		m1 = m1.toLowerCase();
		System.out.println(m1);
// String.valueOf() : primitive data type을 문자열로 반환한다.
		int a = 10;
		String str = String.valueOf(a);
		
		char[] c1 = {'a', 'b', 'c'};
		String str1 = String.valueOf(c1);
		System.out.println(str1);
		// ssn : 111111-1111118 / - : 토큰
// split(String delimiter) : 문자열을 구분자(delimiter)로 토큰(token)화 시키는 메서드
		String[] strArray = ssn.split("-");
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
		
		String str2 = String.format("%,.3f", 1000.32420);
		System.out.println(str2);
		
		str2 = String.format("%,d", 1000000);
		System.out.println(str2);
		
		
		
	}
}