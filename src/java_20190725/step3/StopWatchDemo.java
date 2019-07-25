package java_20190725.step3;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopNanoWatch s1 = new StopNanoWatch();
//currentTimeMillis()
//1970. 1. 1 부터 지금까지 시간을 ms로 변환하라.
		s1.start();
		for (long i = 0; i < 30_000_000_000l; i++) { }
		s1.stop();

		double elapsedTime = s1.getElapsedTime();
		System.out.printf("경과시간 : %.9f", elapsedTime);
	}
}