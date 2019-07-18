package java_20190716;
// Ctrl + Shift + F = 자동 들여쓰기
public class OperatorDemo {
	public static void main(String[] args) {
		int a = 10, b = 22;
		int c = 0;
		double d = 0;

		c = a + b;
		System.out.println(c);

		c = a - b;
		System.out.println(c);

		c = a * b;
		System.out.println(c);

		d = (double) b / (double) a;
		System.out.println(d);

		c = b % a;
		System.out.println(c);

		a += b; // a = a + b;
		System.out.println(a);
		
		int sum = 0;
		
		for (int i = 0; i <= 100; i++) {			
			sum += i;
		}
		System.out.println(sum);
		
		a++; b++;
		c = a++; // 대입 후 증가
		System.out.println(c);
		c = ++b; // 증가 후 대입
		System.out.println(c);
		
		a = 10; b = 20;
		boolean isSuccess = false;
		
		isSuccess = a > b;
		System.out.println(isSuccess);
		
		isSuccess = a < b;
		System.out.println(isSuccess);
	
		isSuccess = a >= b;
		System.out.println(isSuccess);
		
		isSuccess = a <= b;
		System.out.println(isSuccess);
		
		isSuccess = a == b;
		System.out.println(isSuccess);
		
		isSuccess = a != b;
		System.out.println(isSuccess);
		// && 앞이 false = short circuit 발생, || 앞이 true = short, circuit 발생.
		// short circuit 발생 시 뒤의 식은 연산하지 않음.
		isSuccess = (a == b) || (++a == b++);
		System.out.println(!isSuccess);
		System.out.println(a);
		System.out.println(b);
	}
}

// System.out.println(1+2+3+"4"+5+6) => 6456