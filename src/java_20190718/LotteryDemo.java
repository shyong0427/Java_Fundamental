package java_20190718;

import java.util.Arrays;

public class LotteryDemo {
	public static void main(String[] args) {
//// Math.random() = 0보다 크거나 같고 1보다 작은 양수를  double값으로 반환.
//		double random = Math.random();
//// 1보다 크고 45보다 작은 값을 반환하는 temp
//		int temp = (int)(random * 45) + 1;
//		
//		System.out.println(random);
//		System.out.println(temp);
//// 로또 번호 6개 뽑아내기		
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
//			double random = Math.random();
//			int temp = (int) (random * 45) + 1;
//			lotto[i] = temp;
			lotto[i] = (int) (Math.random() * 45) + 1;
			
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i=0;i<lotto.length;i++) {
			for (int j = 0; j < lotto.length-(i+1); j++) {
				if(lotto[j]>lotto[j+1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}
}