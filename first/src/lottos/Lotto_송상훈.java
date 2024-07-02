package lottos;

import java.util.LinkedHashSet; // 삽입 순서 유지
import java.util.Random; // 난수를 생성
import java.util.Set; //Set은 중복을 허용하지 않음

public class Lotto_송상훈 { // Lotto 클래스 선언
	public static void main(String[] args) { // main 메소드 선언
		Random random = new Random(); // Random: 난수를 생성하는 클래스 객체 // random : Random을 가리키는 참조변수
		Set<Integer> lottoNumbers = new LinkedHashSet<>(); // 로또번호를 저장할 Set을 초기화

		// 1. 중복되지 않는 6개의 로또 번호 생성
		while (lottoNumbers.size() < 6) {
			int randomNumber = random.nextInt(45) + 1; // 1부터 45 사이의 난수 생성
			lottoNumbers.add(randomNumber);
		}

		// 2. 보너스 번호 생성
		int bonusNumber;
		do {
			bonusNumber = random.nextInt(45) + 1;
		} while (lottoNumbers.contains(bonusNumber)); // 보너스 번호는 중복되지 않는 번호여야 함

		// 결과 출력
		System.out.print("777회차 로또 번호: " + lottoNumbers);
		System.out.println(" 보너스 번호: " + bonusNumber);
		System.out.println("축하드립니다.");
	}

}
