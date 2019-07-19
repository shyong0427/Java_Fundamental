package java_20190719;

public class ArrayCopyDemo {
	public static void main(String[] args) {
		String[] fruits = {"apple", "banana", "watermelon", "blueberry"};
		String[] temp = new String[6];
//// (원본배열, 원본배열의 복사시작위치, 복사 할 배열이름, 복사 할 배열의 시작위치, 복사 될 것의 목적위치)		
		System.arraycopy(fruits, 0, temp, 2, 4);
		temp[0] = "peach";
		temp[1] = "rasberry";
		
		for (String str : temp) {
			System.out.println(str);
		}
	}
}