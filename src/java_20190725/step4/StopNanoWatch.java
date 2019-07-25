package java_20190725.step4;

public class StopNanoWatch {
	long startTime, stopTime;
	
	public void start() {
		startTime = System.nanoTime();
	}
	
	public void stop() {
		stopTime = System.nanoTime();
	}
	
	public double getElapsedTime() {
		return (double)(stopTime - startTime) / (double) 1000000000;
	}
}
