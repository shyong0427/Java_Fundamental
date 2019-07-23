package java_20190723;

public class Admin {
	private String id, pwd, email;
	private int level;
// default constructor - Alt + Shift + S, C
	public Admin() {
		super(); // 부모 클래스의 디폴트 생성자 호출
	}
// 생성자(Constructor) 
// 생성자는 반환값이 없고, 이름은 클래스 이름과 동일하게 한다.
// 역할 - 인스턴스 변수 초기화 - Alt + Shift + S, O
	public Admin(String id, String pwd, String email, int level) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.level = level;
	}
	
	public Admin(String id, String pwd, String email) {
//		this.id = id;
//		this.pwd = pwd;
//		this.email = email;
//		this.level = level;
		this(id, pwd, email, 0); // 다른 생성자 호출, String = null, primitive value = 0 으로 초기화.
// this 용법
// 1. 자기자신 객체 - this.매개변수1
// 2. 다른 생성자 호출  - this(매개변수1, 매개변수2); > 생성자에서만 사용가능
	}
// instance 변수의 	자동 getter, setter 생성 - Alt + Shift + S - R - Tab - Enter - Tap * 4 - Enter
	public String getId() {
		return id;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}