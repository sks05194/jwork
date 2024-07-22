package lottos;

import java.util.*;

public class Lotto_김민지 {
	public static void main(String[] args) {
		int lottoRound = 777;
		System.out.println(lottoRound + "회차 로또 당첨번호: ");
		
		//중복되지 않는 숫자를 뽑기 위해 Set
		Set<Integer> lottoNum = new HashSet<>();
		
		//1부터 45까지의 숫자를 6개 뽑음
		while(true) {
			int lottoBound = (int)(Math.random() * 45) + 1;
			lottoNum.add(lottoBound);
			if(lottoNum.size() == 6 ) break;
		}
		
		//배열로 변경
		Integer[] arrLotto = lottoNum.toArray(new Integer[0]);
		//숫자 오름차순 나열
		Arrays.sort(arrLotto);
		
		//보너스번호 선언
		int bonusNum;
		
		//1부터 6번까지 순서대로 배열을 나열한 숫자를 출력
		for(int i = 0; i < arrLotto.length; i++) {
			if (arrLotto[i] != arrLotto[5]) {
				System.out.print(arrLotto[i] + ", ");
			} else System.out.print(arrLotto[i] + " + [보너스번호] ");
		}
		//보너스 번호는 앞에 뽑은 6개의 번호와 달라야 함
		while (true) {
			bonusNum = (int)(Math.random() * 45) + 1;
			if (!lottoNum.contains(bonusNum)) break;
		}
		//보너스 번호 출력
		System.out.print(bonusNum);
	}
}
