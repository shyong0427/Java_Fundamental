package java_20190729;

public interface InterA extends InterB, InterC {
// 인터페이스 변수 public static final이 생략되어 있음.
	public static final double PI = 3.14;
// 인터페이스 메서드의 접근 한정자를 붙이지 않으며 public이 생략되어 있음.
// public abstract 생략 가능(추상메서드이기 때문에).
	public abstract void mA();
}