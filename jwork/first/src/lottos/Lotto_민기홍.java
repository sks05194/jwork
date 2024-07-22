package lottos;

import java.util.Arrays;

public class Lotto_민기홍 {
	public static void main(String[] args) {
		int lotto[] = new int[6];
		System.out.print("금주 로또 번호는:");
		for (int i = 0; i < lotto.length; i++) {
			int num = (int) (Math.random() * 46) + 1;
			lotto[i] = num;
			for (int y = 0; y < i; y++) {
				if (lotto[i] == lotto[y]) {
					i--;
					break;
				}

			}
		}
		Arrays.sort(lotto);
		int b = (int) (Math.random() * 46) + 1;
		for (int i = 0; i < lotto.length; i++) {
			if (b == lotto[i]) {

				i--;
			}

		}

		System.out.print(Arrays.toString(lotto));
		System.out.print(" + 보너스번호: " + "[" + b + "]");
	}
}