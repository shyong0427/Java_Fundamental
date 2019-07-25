package java_20190725.step2;

public class StopWatch {
	long startTime, endTime;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		endTime = System.currentTimeMillis();
	}
	public double getElapsedTime() {
		return (double)(endTime - startTime) /(double)1000;
	}
	
	long startNanoTime, endNanoTime;
	
	public void startNano() {
		startNanoTime = System.nanoTime();
	}
	
	public void stopNano() {
		startNanoTime = System.nanoTime();
	}
	
	public double getElapsedNanoTime() {
		return (double)(endNanoTime - startNanoTime) / (double)1000000000;
	}
}