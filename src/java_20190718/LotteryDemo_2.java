package java_20190718;

public class LotteryDemo_2 {
	public static void main(String[] args) {
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
//// temp는 1보다 크거나 같거나 45보다 작거나 같은 임의의 값을 매번 새로 생성
			int temp = (int) (Math.random() * 45) + 1;
//// i = 0 무조건 임의의 temp 값 입력, 비교 불필요
			if (i == 0)
				lotto[i] = temp;
			else {
//// isExisted는 임의의 값 temp와 이전 배열의 값을 비교.
//// 동일 시 true, 아닐 시 false를 반환.
				boolean isExisted = false;
//// i == 1, 아래의 for loop는 1번 반복
//// i == 2, 아래의 for loop는 2번 반복 ...
				for (int j = 0; j < i; j++) {
					if (lotto[i] == temp) {
//// 새로 생성한 temp와 이전 배열의 값을 비교, 같은 값 존재 시 temp값을 재생성
						isExisted = true;
						break;
					}
				}
//// 존재하지 않을 시 새로운 값 입력, 존재 시 이전 위치로 이동.				
				if (!isExisted)
					lotto[i] = temp;
				else
					i--;
			}
		}
//// 오름차순 정리.		
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