package java_20190725.step2;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopWatch s1 = new StopWatch();
//currentTimeMillis()
//1970. 1. 1 부터 지금까지 시간을 ms로 변환하라.
//		s1.startTime = System.currentTimeMillis();

		s1.startNano();
		for (long i = 0; i < 30_000_000_000l; i++) {
		}
		s1.stopNano();

		double elapsedTime = s1.getElapsedNanoTime();
		System.out.printf("경과시간 : %.6f", elapsedTime);
	}
}