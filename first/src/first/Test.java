package first;

import java.util.Random;
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
		Random r = new Random();
		
		print("0 이상 100 이하의 정수를 입력해주세요.");
	}
}









