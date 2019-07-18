//  Calender Condition
// 1년 1월 1일 월요일이다.
// 1년 365일, 윤년일 때는 366일 - 2월 29일이다.
// 윤년은 4년마다 발생, 100의 배수는 제외하고 400의 배수는 제외하지 않는다.
// 2019년 12월 25일 ?요일 
// 모든 일 수를 더한 후, 7로 나눴을 때 나머지에 따라 요일이 달라진다. 
// 2018년까지 총 일수, 11월까지 총 일수, 남은 일수를 더한 후, 7로 나눈 나머지가 1 = 월요일, 2 = 화요일 ... 이다.

package java_20190716;

public class CalenderDemo {
	public static void main(String[] args) {
		int year = 2020, month = 3, days = 15;
		//preYear = 2018년, preMonth = 2019년 11월
		int preYear = year - 1, preMonth = month - 1;
		int totalCount = 0;
		// 2018년까지 총일 수 더하기
		totalCount = preYear * 365 + (preYear/4 - preYear/100 + preYear/400);
		// 2019년 11월까지 합 구하기
		totalCount += 60;
		totalCount += days;
		
		int dayOfWeek = totalCount%7;
		String message = null;
		if (dayOfWeek == 1) message = "월요일";
		else if (dayOfWeek == 2) message = "화요일";
		else if (dayOfWeek == 3) message = "수요일";
		else if (dayOfWeek == 4) message = "목요일";
		else if (dayOfWeek == 5) message = "금요일";
		else if (dayOfWeek == 6) message = "토요일";
		else if (dayOfWeek == 0) message = "일요일";
		System.out.println(year + "년 " + month + "월 " + days + "일 " + message);
/*	
		//2018년도 까지의 총 일 수 구하기
		for (int i = 0; i <= preYear; i++) {
			if (preYear%4 == 0) totalCount++;
			else if (preYear%100 == 0) totalCount--;
		//	else if (preYear%400 == 0) totalCount++;
			else if (preYear%100 == 0 || preYear%400 == 0) totalCount++;
		}
		
		for (int i = 0; i <= preMonth; i++) {
			for (int j = 0; j <= days; j++) {
				totalCount++;
			}
		}
		
		int dayOfWeek = totalCount % 7;
		String message = null;
		
		if (dayOfWeek == 1) message = "월요일";
		else if (dayOfWeek == 2) message = "화요일";
		else if (dayOfWeek == 3) message = "수요일";
		else if (dayOfWeek == 4) message = "목요일";
		else if (dayOfWeek == 5) message = "금요일";
		else if (dayOfWeek == 6) message = "토요일";
		else if (dayOfWeek == 0) message = "일요일";
		System.out.println(year + "년 " + month + "월 " + days + "일 " + message);
	*/		

	}
}