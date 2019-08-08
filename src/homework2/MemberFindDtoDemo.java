package homework2;

public class MemberFindDtoDemo {
	public static void main(String[] args) {
		// 1. 객체를 생성한다.
		MemberFindDto m1 = new MemberFindDto(1, "shyong0427@daum.net", "111", "2019-08-08", "2019-08-08");
		// 2. 객체의 내용을 출력한다.
		System.out.println(m1.getSeq());
		System.out.println(m1.getEmail());
		System.out.println(m1.getCode());
		System.out.println(m1.getSdate());
		System.out.println(m1.getEdate());
		// 3. 객체의 내용을 수정한다.
		m1.setSeq(1111);
		m1.setEmail("shyong0427_1@daum.net");
		m1.setCode("12121212");
		m1.setSdate("2019-09-01");
		m1.setEdate("2019-09-02");		
		// 4. 객체의 내용을 출력한다.
		System.out.println(m1.getSeq());
		System.out.println(m1.getEmail());
		System.out.println(m1.getCode());
		System.out.println(m1.getSdate());
		System.out.println(m1.getEdate());
		

		MemgerFindDto m2 = new MemberFindDto(2, "shyong0427@daum.net", "2222", "2019-08-01", "2019-08-02");

	}
}
