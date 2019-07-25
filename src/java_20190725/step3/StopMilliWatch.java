package java_20190725.step3;

public class StopMilliWatch {
	long startTime, stopTime;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	public double getElapsedTime() {
		return (double)(stopTime - startTime) / (double) 1000;
	}
}