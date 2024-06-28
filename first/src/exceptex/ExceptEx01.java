package exceptex;

public class ExceptEx01 {
	public static void main(String[] args) {
		System.out.println("시스템이 시작 되었습니다.");
		
		@SuppressWarnings("unused")
		int c;
		
		System.out.println("프로그램을 실행하는 중입니다.1");
//		c = 4 / 0;
		
		try {
			System.out.println("프로그램을 실행하는 중입니다.2");
			c = 4 / 0;
			System.out.println("프로그램을 실행하는 중입니다.3");
		} catch (ArithmeticException e) {
			System.out.println("젯수(나누는 수)는 0이 될 수 없습니다.");
			System.out.println("0 이상이 되도록 변경해주세요.");
			System.out.println(e.getMessage());
		}
		
		System.out.println("시스템이 정상 종료되었습니다.");
	}
}