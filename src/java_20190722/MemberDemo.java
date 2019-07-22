package java_20190722;

public class MemberDemo {
	public static void main(String[] args) {
		Member m = new Member();
//		m.name = "djfiwojeflsj";
		m.setName("심헌용");
//		System.out.println(m.name);
//		m.setAddress("서울");
//		m.setSsn("11111-11118");
		m.setZipcode("745-18");
		m.setAddr1("경기도");
		m.setAddr2("동두천시");
		m.setSsn1("111111");
		m.setSsn2("111118");
		m.setRegdate("2019-07-22");
		m.setAge(26);
		
		System.out.println(m.getName());
//		System.out.println(m.getAddress());
//		System.out.println(m.getSsn());
//		System.out.println(m.getAge());
//		System.out.println(m.getRegdate());
		System.out.println(m.getZipcode());
		System.out.println(m.getAddr1());
		System.out.println(m.getAddr2());
		System.out.println(m.getSsn1());
		System.out.println(m.getSsn2());
		System.out.println(m.getRegdate());
		System.out.println(m.getAge());
		
		
	}
}