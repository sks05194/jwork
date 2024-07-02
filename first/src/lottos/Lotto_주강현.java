package lottos;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto_주강현 {
	public void print() {
		System.out.println("★복권 번호추첨 프로그램입니다★\n메뉴를 선택하세요.");
		System.out.print("1.시작\n2.종료\n입력: ");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lotto_주강현 p = new Lotto_주강현();
		p.print();
		int count = 0;
		while (true) {
			int[] number = new int[6];
			int num = scanner.nextInt();
			if (num > 2) {
				System.out.println("잘못 입력하였습니다.다시 입력해주세요");
				p.print();
			}
			if (num == 1) {
				count++;
				int bonus = (int) (Math.random() * 45) + 1;
				System.out.print("\n" + count + "번째 추첨번호:");
				for (int i = 0; i < number.length; i++) {
					number[i] = ((int) (Math.random() * 45) + 1);
				}
				Arrays.sort(number);
				System.out.print(Arrays.toString(number));
				System.out.println("+보너스번호: " + bonus);
				System.out.print("\n1.재추첨\n2.종료\n입력: ");
			}
			if (num == 2) {
				System.out.println("프로그램이 종료됩니다.이용해 주셔서 감사합니다.");
				break;
			}

		}
		scanner.close();
	}
}
