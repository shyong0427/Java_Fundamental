package java_20190718;
//// Calender Condition
//// 1년 1월 1일 월요일
//// 1년 = 365일, 윤년의 1년 = 366일 (2월 29일)
//// 윤년 = 4년 마다 발생, 100의 배수년은 제외, 400의 배수년은 포함
//// 2019년 12월 25일은 무슨 요일인가?
//// 모든 일 수를 더한 후, 7로 나눴을 때 나머지에 따라 요일이 달라진다.
//// 2018년까지 총 일수 + 11월까지의 총 일수 + 남은 일수를 더한 후, 7로 나눈다.
//// 나머지가 1 = 월, 2 = 화, 3 = 수, ... 이다.
public class CalnderSolve {
	public static void main(String[] args) {
		int year = 2020, month = 1, days = 2;
		int preYear = year - 1, preMonth = month - 1;
		int cnt = 0;
		int[] monthArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		boolean isLeafYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		
		cnt = preYear * 365 + (preYear/4 - preYear/100 + preYear/400);
		
		if (isLeafYear) monthArray[1] = 29;
		
		for (int i = 0; i < preMonth; i++) cnt += monthArray[i];
		cnt += days;
		
		int dayOfWeek = cnt % 7;
		String message = null;
		
		if (dayOfWeek == 1) message ="월요일";
		else if (dayOfWeek == 2) message = "화요일";
		else if (dayOfWeek == 3) message = "수요일";
		else if (dayOfWeek == 4) message = "목요일";
		else if (dayOfWeek == 5) message = "금요일";
		else if (dayOfWeek == 6) message = "토요일";
		else if (dayOfWeek == 0) message = "일요일";
		
		System.out.println(year + "년 " + month + "월 " + days + "일 " + message + "입니다.");
	}
}