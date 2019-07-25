package java_20190725.step1;
// 요구사항
// 1. ms로 경과 시간을 만들어라
public class FootStopWatch {
	long startTime, endTime;
	
	public double getElapseTime() {
		return (double)(endTime - startTime) /(double)1000;
	}
	public static void main(String[] args) {
		FootStopWatch f1 = new FootStopWatch();
//currentTimeMillis()
//1970. 1. 1 부터 지금까지 시간을 ms로 변환하라.
		f1.startTime = System.currentTimeMillis();
		
		for (long i = 0; i < 30_000_000_000l; i++) {
		}
		
		f1.endTime = System.currentTimeMillis();
		double elapsedTime = f1.getElapseTime();
		System.out.printf("경과시간 : %.3f", elapsedTime);
	}
}