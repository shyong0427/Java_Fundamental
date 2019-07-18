package java_20190717;

public class WhileDemo {
	public static void main(String[] args) {
//		int sum = 0, i = 1;
//		
//		while(i <=10 ) {
//			sum += i;
//			i++;
//		}
//		System.out.printf("1부터 10까지의 합은 %d 입니다.\n", sum);
//	구구단 구하기
//		int first = 2;
//		
//		while(first <= 9) {
//			int second = 1;
//			
//			while (second <= 9) {
//				System.out.printf("%d * %d = %d \n", first, second, first * second);
//				second++;
//			}
//			first++;
//		}
// 구구단 역순 구하기
		int first = 9;

		while (first >= 2) {
			int second = 1;

			while (second <= 9) {
				System.out.printf("%d * %d = %d \n", first, second, first * second);
				second++;
			}
			first--;
		}
	}
}