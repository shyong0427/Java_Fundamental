package java_20190722;

public class Member {
//	private String name, address, ssn, regdate;
//	int age;	
////// name = setter(변경가능), getter 메서드
////// name에 대한 getter메서드 = instance name정보를 가져올 수 있는 메서드
//	public String getName() {
//		return this.name;
//	}
////// name에 대한 setter메서드 = instance name정보를 변경할 수 있는 메서드
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getAddress() {
//		return address;
//	}
//	
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	
//	public String getSsn() {
//		return ssn;
//	}
//	
//	public void setSsn(String ssn) {
//		this.ssn = ssn;
//	}
//	
//	public String getRegdate() {
//		return regdate;
//	}
//	
//	public void setRegdate(String regdate) {
//		this.regdate = regdate;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	
//	public void setAge(int age) {
//		this.age = age;  
//	}
	
	private String name, Zipcode, addr1, addr2, ssn1, ssn2, regdate;
	int age;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setZipcode(String Zipcode) {
		this.Zipcode = Zipcode;
	}
	
	public String getZipcode() {
		return Zipcode;
	}
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
	public String getAddr2() {
		return addr2;
	}
	
	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}
	
	public String getSsn1() {
		return ssn1;
	}
	
	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}
	
	public String getSsn2() {
		return ssn2;
	}
	
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public String getRegdate() {
		return regdate;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}