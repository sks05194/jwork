package first;

public class Test1 {
	// 출력 대체코드
	public static void println(Object obj) {
		System.out.println(obj);
	}
	public static void print(Object obj) {
		System.out.print(obj);
	}
	public static void println() {
		System.out.println();
	}

	public static void main(String[] args) {
		int year = 2024;

		println(year + "년도의 월별 일자 수 출력\n");
		
		for (int m = 1; m <= 12; m++) {
			int days;
			
			switch (m) {
			case 2:
				days = year % 4 == 0 ? 29 : 28;
				break;
			case 4: case 6: case 9: case 11:
				days = 30;
				break;
			default:
				days = 31;
			}
			System.out.printf("%2d월: %d일\n", m, days);
		}
	}
}
