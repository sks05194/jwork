package first;

import java.util.Scanner;

public class Test {
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
		Scanner sc = new Scanner(System.in);
		
		// for문
		println("for문 무한루프");
		for(;;) {
			print("정수값을 입력해주세요 : ");
			int a = sc.nextInt();

			print("정수값을 입력해주세요 : ");
			int b = sc.nextInt();
			
			int result = a + b;
			if(result >= 12) {
				println("값은 : " + result + "입니다.");
				break;
			} else {
				println("숫자가 12이상이 되는 값으로 넣어야 합니다.");
			}
		}

		// while문
		println("while문 무한루프");
		while (true) {
			print("정수값을 입력해주세요 : ");
			int a = sc.nextInt();

			print("정수값을 입력해주세요 : ");
			int b = sc.nextInt();

			int result = a + b;
			if (result >= 12) {
				println("값은 : " + result + "입니다.");
				break;
			} else {
				println("숫자가 12이상이 되는 값으로 넣어야 합니다.");
			}
		}

		// do~while문
		println("do~while문 무한루프");
		do {
			print("정수값을 입력해주세요 : ");
			int a = sc.nextInt();

			print("정수값을 입력해주세요 : ");
			int b = sc.nextInt();

			int result = a + b;
			if (result >= 12) {
				println("값은 : " + result + "입니다.");
				break;
			} else {
				println("숫자가 12이상이 되는 값으로 넣어야 합니다.");
			}
		} while (true);
	}
}










