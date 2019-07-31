package java_20190730;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagementDemo {
	private ArrayList<Member> list;

	public MemberManagementDemo() {
//		super();  // 생략되어 있다.
		list = new ArrayList<Member>();
	}

	public void print() {
		System.out.println("***********************************************************");
		System.out.println("* 1. insert   2. update   3. delete   4. search   5. exit *");
		System.out.println("***********************************************************");
	}

	public String console(String msg) {
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

// 1. 아이디를 입력받는다.
// 2. 이름을 입력받는다.
// 3. ArrayList에 고객을 추가한다.
// 4. ArrayList에 있는 고객을 모두 출력한다.
// 5. print() 메서드를 호출한다.
// 6. 번호를 선택하세요 > 메세지를 출력한 후 키보드 입력을 받게 한다.
	private void intsert() {
		// TODO Auto-generated method stub
		String id = console("아이디를 입력하세요 > ");
		String name = console("이름을 입력하세요 > ");

		Member m1 = new Member(id, name);
		list.add(m1);

		common();
	}

// 1. 수정할 아이디를 입력받는다.
// 2. ArrayList에서 수정 할 아이디를 찾아서 있으면
//	     수정할 이름을 입력받고, ArrayList에 고객정보를 수정하고, 
//	     없으면 수정 할 아이디가 없습니다. 메세지를 출력.
// 3. ArrayList에 있는 모든 고객을 출력한다.
// 4. print(); 메서드 호출
// 5. 번호를 선택하세요 > 메세지 출력한 후 키보드 입력을 받게 한다.
	private void update() {
		// TODO Auto-generated method stub
		String updateId = console("수정 할 아이디를 입력하세요 > ");
		boolean isExisted = false;

		for (Member member : list) {
			if (updateId.equals(member.getId())) {
				isExisted = true;
				break;
			}
		}

		if (isExisted) {
			String updateName = console("수정할 이름을 입력하세요 > ");

			for (Member member : list) {
				if (updateId.equals(member.getId())) {
					member.setName(updateName);
					break;
				}
			}
		} else {
			System.out.println("수정할 아이디가 존재하지 않습니다.");
		}

		common();
	}

// 1. 삭제 할 아이디를 입력받는다.
// 2. ArrayList의 Member 객체 중에서 삭제할 아이디가 있으면 삭제하고 없으면 삭제할 아이디가 없습니다. 메세지 출력.
// 3. ArrayList에 있는 모든 고객을 출력한다.
// 4. print() 호출
// 5. 번호를 입력하세요 > 메세지를 출력한 후 키보드 입력을 받게한다.
	private void delete() {
		// TODO Auto-generated method stub
		String deleteId = console("삭제할 아이디를 입력하세요 > ");
		boolean isExisted = false;

		for (Member member : list) {
			if (deleteId.equals(member.getId())) {
				isExisted = true;
				list.remove(member);
				break;
			}
		}

		if (!isExisted) {
			System.out.println("삭제할 아이디가 존재하지 않습니다.");
		}

		common();
	}
	
// 1. 검색할 아이디를 입력하세요 > 
// 2. ArrayList에 Member객체에 검색할 아이디를 찾아서 있으면 출력하고, 없으면 검색할 아아디가 없습니다. 출력
// 3. ArrayList에 있는 모든 고객을 출력한다.
// 4. print() 호출.
// 5. 번호를 입력하세요 > 메세지를 출력한 후 키보드 입력을 받게한다.
	private void search() {
		// TODO Auto-generated method stub
		String searchId = console("검색할 아이디를 입력하세요 > ");
		System.out.println("*************** 검색결과  ***************");
		boolean isExisted = false;
		
		for (Member member : list) {
			if (searchId.equals(member.getId())) {
				System.out.println(member);
				isExisted = true;
				break;
			}
		} 
		
		if (!isExisted) {
			System.out.println("검색한 아이디가 존재하지 않습니다.");
		}
		System.out.println("**************************************");
		
		common();
	}

	private void common() {
		for (Member member : list) {
			System.out.println(member);
		}

		print();
		String index = console("번호를 선택하세요>");
		run(index);
	}

	private void run(String selectedIndex) {
		// TODO Auto-generated method stub
		if (selectedIndex.equals("1")) {
			intsert();
//			System.out.println("insert.....");
		} else if (selectedIndex.equals("2")) {
			update();
//			System.out.println("update.....");
		} else if (selectedIndex.equals("3")) {
			delete();
//			System.out.println("delete.....");
		} else if (selectedIndex.equals("4")) {
			search();
//			System.out.println("search.....");
		} else if (selectedIndex.equals("5")) {
			System.out.println("exit.....");
		} else {
			System.out.println("warning.....");
			print();
			String index = console("번호를 선택하세요>");
			run(index);
		}
	}

	public static void main(String[] args) {
		MemberManagementDemo m1 = new MemberManagementDemo();
		m1.print();
		String selectedIndex = m1.console("번호를 선택하세요>");
		m1.run(selectedIndex);
	}
}