package java_20190723;

public class PrimeNumber {
	public void printPrimeNumber(int temp) {
// temp = 50이면 50이하의 소수를 모두 구하여 출력한다.
//		int cnt = 0;
		System.out.println(temp + "이하의 소수를 모두 구하시오.");
//		for (int i = 2; i <= temp; i++) {
//			for (int j = 2; j <= i; j++) {
//				if (i % j == 0) {
//					System.out.print(i + " ");
//					cnt++;
//				}
//			}
//		}
//		System.out.printf("결과 : %d", cnt);
//	}
		boolean isPrimeNumber = false;
		int cnt = 0;
		for (int i = 2; i <= temp; i++) {
			isPrimeNumber = true;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				cnt++;
				System.out.print(i + "\t");
			}
		}
		System.out.println();
		System.out.printf("소수의 갯수 : %s %n", cnt);
	}

	public int[] getPrimeNumber(int temp) {
		int[] array = new int[temp];
		boolean isPrimeNumber = false;
		int cnt = 0;
		for (int i = 2; i <= temp; i++) {
			isPrimeNumber = true;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber) {
				array[cnt] = i;
				cnt++;
			}
		}
		int[] copyArray = new int[cnt];
		System.arraycopy(array, 0, copyArray, 0, cnt);
		return copyArray;
	}
}