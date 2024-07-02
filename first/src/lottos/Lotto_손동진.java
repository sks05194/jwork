package lottos;

import java.util.Random;

public class Lotto_손동진 {

	public static void main(String[] args) {
		Random r1 = new Random();

		for (int i = 0; i < 1; i++) {
			System.out.println("[보너스 번호]" + (r1.nextInt(45) + 1) + "]");
		}

		for (int j = 1; j <= 7; j++) {
			System.out.println("[로또 번호]" + (r1.nextInt(45) + 1) + "]");
		}

	}
}