package lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Lotto_한지수 {

	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> lotto = new HashSet<Integer>();

		for (int i = 1; i <= 6; i++) {
			int num = random.nextInt(45);
			lotto.add(num);
		}

		List<Integer> lotto2 = new ArrayList<>(lotto);
		Collections.sort(lotto2);

		int bonus;
		do {
			bonus = random.nextInt(45) + 1;
		} while (lotto.contains(bonus));

		System.out.print("777회차 로또 당첨번호 : ");
		for (int num : lotto2) {
			System.out.print(num + ", ");
		}
		System.out.println("+ [보너스 번호] " + bonus);
	}

}
