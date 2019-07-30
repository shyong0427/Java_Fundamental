package java_20190730;

import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
// auto-import : Ctrl + Shift + o
// HashSet은 데이터(객체)의 중복을 허용하지 않고 순서가 없다.
//		HashSet set = new HashSet(); // 선언
// TreeSet은 데이터(객체)의 중복을 허용하지 않고 오름차순 정렬한다.
		TreeSet<Integer> set = new TreeSet<Integer>();

		while (true) {
			int random = (int) (Math.random() * 45) + 1;
			set.add(random); // 할당, Auto-boxing(primitive data type > wrapper)
//			set.add(new Integer.valueOf(random)); > Auto-boxing 사용하지 않음
// Colletion의 크기는 모두 size() < HashSet의 크기
			if (set.size() == 6) break;
		}

// HashSet이 출력은 Iterator type으로 변경해서 출력해야 한다. 
		Iterator<Integer> i = set.iterator();
// hasNext() HashSet에 출력할 객체가 존재를 판단하는 메서드
		while (i.hasNext()) {
// next() 해당 객체를 가져오는 역할.
// Auto-unboxing(wrapper > primitive data type
//			int temp = (Integer) i.next();
			Integer temp = i.next(); // > Auto-unboxing 사용하지 않음
			System.out.print(temp + "  ");
		}
	}
}