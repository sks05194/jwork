package lottos;

import java.util.Arrays;

public class Lotto_최지혁 {

	public static void main(String[] args) {
		int[] lotto = new int[6]; // 로또번호 6개를 받을 공간 int배열 lotto 선언, 6개를 받기 위해 크기를 6으로 설정
		int max = 45; // 1 ~ 45 내 제한범위를 위한 max 변수 선언 및 제한범위로 45 설정
		int bonus = (int) (Math.random() * max) + 1; // 보너스번호를 위한 bonus 변수 선언, 1부터 45까지의 랜덤한 번호를 초기값으로 설정

		for (int i = 0; i < lotto.length; i++) {
			// Math.random()는 0.0 ~ 0.999... 이내의 숫자를 반환함. 따라서 로또번호인 조건에 맞춰 1.0~45.99999까지 출력될 수 있도록 +1을 해주고, 동시에 1~45까지의 숫자가 되기 위해 정수형으로 형 변환 진행
			lotto[i] = (int) (Math.random() * max) + 1; // 1부터 45까지의 랜덤번호를 lotto i번째 인덱스에 저장

			for (int j = 0; j < i; j++) { // 방금 생성된 번호가 기존에 생성된 번호와 중복되는지 확인하기 위한 코드
				if (lotto[i] == lotto[j]) { // 만약 중복일 경우엔
					i--; // 인덱스를 감소시킨다.
					break; // j가 포함된 반복문 종료. 따라서 i가 포함된 반복문의 내부 코드가 종료되어 i++가 진행된다.
				}
			}

			if (bonus == lotto[i]) { // 만약 보너스번호가 lotto i번째 인덱스와 동일하다면
//				System.out.println("중복발생");
				bonus = (int) (Math.random() * max) + 1; // 보너스번호를 랜덤번호로 재설정합니다.
			}
		}

		Arrays.sort(lotto); // lotto를 오름차순 정렬
		System.out.print("777회 로또 당첨번호 : ");

		for (int number : lotto) { // for(int i = 0; i < lotto.length; i++)와 동일하다.
			System.out.print(number + " "); // number가 lotto 배열의 값을 받아 출력
		}

		System.out.print("+ [보너스번호] " + bonus);
	}

}