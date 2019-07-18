package java_20190716;

// 각 자릿 수를 2 ~ 9까지 곱한 후, 다시 2 ~ 5까지 곱해서 합을 구한다.
// 총 합을 11로 나눈 나머지를 구한다.
// 11에서 나머지를 뺀다.
// 위의 결과를 10으로 나눈 나머지를 구한다. 
// 위의 결과와 마지막 숫자가 같으면 정상적인 주민번호이다.

public class SsnDemo {
	public static void main(String[] args) {
		int a1 = 1, a2 = 1, a3 = 1, a4 = 1, a5 = 1, a6 = 1;
		int b1 = 1, b2 = 1, b3 = 1, b4 = 1, b5 = 1, b6 = 1, b7 = 8;		
		int sum = 0;
		
		sum = a1 * 2 + a2 * 3 + a3 * 4 + a4 * 5 + a5 * 6 + a6 * 7 + b1 * 8 + b2 * 9 + b3 * 2 + b4 * 3 + b5 * 4 + b6 * 5;
		
		sum = (11 - sum % 11) % 10;
		
		System.out.println(sum);
		if (sum == b7) System.out.println("정상적인 주민 번호 입니다.");
		else System.out.println("확인되지 않았습니다.");
		System.out.println("오늘은 그만!!!!!!!!!!!!!!");
	}
}