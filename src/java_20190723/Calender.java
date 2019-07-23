package java_20190723;

public class Calender {

	public static final int SUNDAY = 0;
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WEDNESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;

	private int getCount(int year, int month, int days) {
		int preYear = year - 1, preMonth = month - 1;
		int totalCount = 0;
		// 2018년까지 총일 수 더하기
		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean isLeafYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

		if (isLeafYear) {
			monthArray[1] = 29;
		}
		// 2019년 11월까지 합 구하기
		for (int i = 0; i < preMonth; i++) {
			totalCount += monthArray[i];
		}
		totalCount += days;

		return totalCount;
	}

	private int getLastDay(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean isLeafYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

		if (isLeafYear) {
			monthArray[1] = 29;
		}

		return monthArray[month - 1];
	}

	public void print(int year) {
		for (int i = 1; i <= 12; i++) {
			print(year, i);
		}
	}

	public void print(int year, int month) {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		// 들여쓰기 기능
		// 2019. 07. 01까지의 총 날짜를 구한다.
		int totalCount = getCount(year, month, 1);
		int rest = totalCount % 7;

		for (int i = 0; i < rest; i++) {
			System.out.print("\t");
		}

		for (int i = 1; i <= getLastDay(year, month); i++) {
			System.out.print(i + "\t");

			if (rest % 7 == Calender.SATURDAY) {
				System.out.println();
			}
			rest++;
		}
		System.out.println();
	}

	public void print(int year, int month, int days) {
//		//preYear = 2018년, preMonth = 2019년 11월
//		int preYear = year - 1, preMonth = month - 1;
//		int totalCount = 0;
//		// 2018년까지 총일 수 더하기
//		totalCount = preYear * 365 + (preYear/4 - preYear/100 + preYear/400);
//		
//		int[] monthArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		boolean isLeafYear = year % 4 == 0 && (year % 100 != 0 || year%400 == 0);
//		
//		if (isLeafYear) monthArray[1] = 29;
//		
//		// 2019년 11월까지 합 구하기
//		for (int i = 0; i < preMonth; i++) {
//			totalCount += monthArray[i];
//		}
//		
//		totalCount += days;

		int totalCount = getCount(year, month, days);
		int dayOfWeek = totalCount % 7;
		String message = null;

		if (dayOfWeek == Calender.MONDAY) {
			message = "월요일";
		} else if (dayOfWeek == Calender.TUESDAY) {
			message = "화요일";
		} else if (dayOfWeek == Calender.WEDNESDAY) {
			message = "수요일";
		} else if (dayOfWeek == Calender.THURSDAY) {
			message = "목요일";
		} else if (dayOfWeek == Calender.FRIDAY) {
			message = "금요일";
		} else if (dayOfWeek == Calender.SATURDAY) {
			message = "토요일";
		} else if (dayOfWeek == Calender.SUNDAY) {
			message = "일요일";
		}
		System.out.println(year + "년 " + month + "월 " + days + "일 " + message);
	}
}