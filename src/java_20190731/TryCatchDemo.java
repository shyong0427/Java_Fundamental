package java_20190731;

public class TryCatchDemo {
	public static double getAvg(int korean, int english) {
		int sum = korean + english;
		double avg = (double) sum / (double) 2;
		return avg;
//		return avg = (double) (korean + english) / double 2;
	}

	public static void main(String[] args) {
		try {
			int korean = Integer.parseInt(args[0]);
			int english = Integer.parseInt(args[1]);
			double average = getAvg(korean, english);
			System.out.printf("평균 : %f", average);
		} catch (NumberFormatException e1) {
//			System.out.println("예외메세지 : " + e1.getMessage());
//			e1.printStackTrace();
			System.err.println("숫자 느으르그 흤을튼드..");
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.err.println("2개 느으르그 흤을튼드..");		
		} finally {
		// 예외 발생 유무와 상관없이 수행되는 블럭
			System.out.println("finally");
		}
	}
}