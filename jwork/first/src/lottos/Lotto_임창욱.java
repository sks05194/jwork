package lottos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Lotto_임창욱 {
	public static void main(String[] args) {
		Random random = new Random();

		ArrayList<Integer> lotto = new ArrayList<>();

		while (true) {
			int num = random.nextInt(45) + 1;
			if (!lotto.contains(num))
				lotto.add(num);
			if (lotto.size() == 6)
				lotto.sort(Comparator.naturalOrder());
			if (lotto.size() == 7)
				break;
		}

		System.out.print("777회차 로또 당첨번호:");

		for (int i = 0; i < lotto.size(); i++) {
			if (i < lotto.size() - 2)
				System.out.print(" " + lotto.get(i) + ",");
			else {
				System.out.print(" " + lotto.get(i) + " +[보너스 당첨번호] " + lotto.get(i + 1));
				break;
			}
		}
	}
}