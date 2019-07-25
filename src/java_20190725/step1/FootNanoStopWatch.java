package java_20190725.step1;

public class FootNanoStopWatch {
	long startTime, endTime;
	long startNanoTime, endNanoTime;
	
	public double getElapseTime() {
		return (double)(endTime - startTime) /(double)1000;
	}
	
	public double getElapseNanoTime() {
		return (double)(endNanoTime - startNanoTime) /(double)1000000000;
	}
	
	public static void main(String[] args) {
		FootNanoStopWatch f1 = new FootNanoStopWatch();
//currentTimeMillis()
//1970. 1. 1 부터 지금까지 시간을 ms로 변환하라.
//		f1.startTime = System.currentTimeMillis();
		f1.startNanoTime = System.nanoTime();
		
		for (long i = 0; i < 30_000_000_000l; i++) {
		}
//		f1.endTime = System.currentTimeMillis();
		f1.endNanoTime = System.nanoTime();
		double elapsedTime = f1.getElapseNanoTime();
		System.out.printf("경과시간 : %.9f", elapsedTime);
	}
}
