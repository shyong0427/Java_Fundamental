package java_20190814;

import java.util.ArrayList;

public class NoticeDemo {
	public static void main(String[] args) {
		NoticeDao nDao = NoticeDao.getInstace();

		boolean isSuccess = nDao.insert(new NoticeDto(0, "shy12", "title12", "content12", ""));

		if (isSuccess) {
			System.out.println("Insert Success !");
		} else {
			System.out.println("Insert Fail...");
		}

		isSuccess = nDao.update(new NoticeDto(10, "shy010", "title010", "content010", ""));

		if (isSuccess) {
			System.out.println("Update Success !");
		} else {
			System.out.println("Update Fail...");
		}

		ArrayList<NoticeDto> list = nDao.select();
		for (NoticeDto n : list) {
			int num = n.getNum();
			String writer = n.getWriter();
			String title = n.getTitle();
			String content = n.getContent();
			String regdate = n.getRegdate();

			System.out.printf("%d, %s, %s, %s, %s \n", num, writer, title, content, regdate);
		}

		isSuccess = nDao.delete(1);

		if (isSuccess) {
			System.out.println("Delete Success !");
		} else {
			System.out.println("Delete Fail...");
		}
	}
}