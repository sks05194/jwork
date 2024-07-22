package lottos;

import java.util.Arrays;

public class Lotto_오대혁 {

	public static void main(String[] args) {
		System.out.print("100회차 로또 당첨번호 : ");
		int[] lotto = new int[6];
		int bonus = (int) (Math.random() * 45 )+ 1;

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 )+ 1;

			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;

				}
			}
		}
		Arrays.sort(lotto);
		for (int i = 0; i < lotto.length; i++) {
			if (lotto[i] == bonus) {
				bonus = (int)(Math.random() * 45) +1;
			} else {
				break;
			}
			
		}
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");

		}
		System.out.print("+ [보너스 번호] " + bonus);
	}

}
