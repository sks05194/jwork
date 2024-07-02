package lottos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lotto_오경숙 {

	public static void main(String[] args) {
		System.out.println("777회차 로또 번호 확인");
		// 당첨 번호 설정
		Set<Integer> winningNumbers = new HashSet<>();
		winningNumbers.add(14);
		winningNumbers.add(22);
		winningNumbers.add(10);
		winningNumbers.add(23);
		winningNumbers.add(11);
		winningNumbers.add(30);
//		int bonusNumber = 16;

		// 사용자로부터 로또 번호 입력 받기
		Scanner sc = new Scanner(System.in);
		Set<Integer> userNumbers = new HashSet<>();
		System.out.println("6개의 로또 번호를 입력하세요 (1~45 사이의 숫자):");
		while (userNumbers.size() < 6) {
			int number = sc.nextInt();
			if (number < 1 || number > 45) {
				System.out.println("번호는 1에서 45 사이여야 합니다. 다시 입력하세요:");
			} else if (!userNumbers.add(number)) {
				System.out.println("같은 번호를 중복하여 입력할 수 없습니다. 다시 입력하세요:");
			}
		}

		// 보너스 번호 입력 받기
		System.out.println("보너스 번호를 입력하세요 (1~45 사이의 숫자):");
//		int userBonusNumber = sc.nextInt();

		// 당첨 번호 검사
		Set<Integer> matchedNumbers = new HashSet<>();
		for (int number : userNumbers) {
			if (winningNumbers.contains(number)) {
				matchedNumbers.add(number);
			}
		}

		// 결과 출력
		if (matchedNumbers.size() > 0) {
			System.out.println("축하합니다! 맞춘 번호는 다음과 같습니다: " + matchedNumbers);
		} else {
			System.out.println("당첨된 번호가 없습니다.");
		}
		sc.close();
	}
}