package lottos;

import java.util.Arrays;
import java.util.Random;

public class Lotto_설보라 {

	public static void main(String[] args) {

		System.out.print("0525회 로또 당첨번호 : ");

		int arr[] = new int[6];
		for (int a = 0; a <= 5; a++) {
			Random random = new Random();
			int num = random.nextInt(45);
			arr[a] = num + 1;
		}
		Arrays.sort(arr);
		for (int j = 0; j <= 5; j++) {
			System.out.print(arr[j] + " ");
		}
		Random random2 = new Random();
		int bonusNum = random2.nextInt(45);
		System.out.println("[보너스번호] " + (bonusNum + 1));
	}
}