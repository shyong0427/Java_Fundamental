package java_20190813;

import java.util.ArrayList;

public class DeptDemo {
	public static void main(String[] args) {
		DeptDao dao = DeptDao.getInstance();
		
		boolean isSuccess = dao.insert(new DeptDto(50, "DEVELOPMENT", "GANGNAM"));
		
		if (isSuccess) {
			System.out.println("부서가 추가되었습니다.");
		} else {
			System.out.println("부서추가가 실패되었습니다.");
		}
		
		isSuccess = dao.update(new DeptDto(50, "개발부", "서초구"));
		
		if (isSuccess) {
			System.out.println("부서가 수정되었습니다.");
		} else {
			System.out.println("부서수정이 실패되었습니다.");
		}
		
		ArrayList<DeptDto> list = dao.select();
		
		for (DeptDto d : list) {
			int no = d.getNo();
			String name = d.getName();
			String loc = d.getLoc();
			System.out.printf("%d, %s, %s \n", no, name, loc);
		}
		
		isSuccess = dao.delete(50);
		
		if (isSuccess) {
			System.out.println("부서가 삭제되었습니다.");
		} else {
			System.out.println("부서 삭제가 실패되었습니다.");
		}
	}
}