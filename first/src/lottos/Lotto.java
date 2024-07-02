package lottos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		HashSet<Integer> numBox = new HashSet<>();
		Random rd = new Random();
		while(true) {
			numBox.add(rd.nextInt(45)+1);
			if(numBox.size() == 7) break; 
		}
		// 5 25 3 7 17 6 2
		Integer[] allNum = numBox.toArray(new Integer[0]);
		Integer[] prizeNum = new Integer[6];
		
		System.arraycopy(allNum, 0, prizeNum, 0, 6);
		Arrays.sort(prizeNum);
		
		System.out.print("777회차 로또 당첨번호 : ");
		for(int i = 0; i < prizeNum.length ; i++) {
			if(i == prizeNum.length -1 ) System.out.print(prizeNum[i]);
			else System.out.print(prizeNum[i] + ", ");
		}
		System.out.println(" + [보너스번호] "+allNum[allNum.length-1]);
	}

}
