package java_20190812;

import java.util.ArrayList;

public class MemberDemo {
	public static void main(String[] args) {
		MemberDao mdao = MemberDao.getInstance();/*
		MemberDto m1 = new MemberDto(27, "trumph1", "usa1");
		boolean isSuccess = mdao.insert(m1);
		
		if (isSuccess) {
			System.out.println("Insert Success!");
		} else {
			System.out.println("Insert Fail...");
		}
		
		m1 = new MemberDto(27, "Trumph2", "USA2");
		isSuccess = mdao.update(m1);
		if (isSuccess) {
			System.out.println("Change Success!");
		} else {
			System.out.println("Change Fail...");
		}
		
		isSuccess = mdao.delete(26);
		if (isSuccess) {
			System.out.println("Delete Success!");
		} else {
			System.out.println("Delete Fail...");
		}*/
		
		ArrayList<MemberDto> list = mdao.select();
		
		for (MemberDto m : list) {
			System.out.printf("%d \t %s \t %s \t \n", m.getNum(), m.getName(), m.getAddr());
		}
		
	}
}