package java_20190812;

public class MemberDemo {
	public static void main(String[] args) {
		MemberDao mdao = MemberDao.getInstance();
		MemberDto m1 = new MemberDto(21, "trumph", "usa");
		boolean isSuccess = mdao.insert(m1);
		
		if (isSuccess) {
			System.out.println("Success!");
		} else {
			System.out.println("Fail...");
		}
	}
}