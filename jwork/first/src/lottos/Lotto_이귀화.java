package lottos;

import java.util.HashSet;

public class Lotto_이귀화 {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		int number;
		System.out.print("로또번호: ");
		do{
			number = (int)(Math.random() * 45 +1);
			lotto.add(number);
			lotto.add(number);
			lotto.add(number);
			lotto.add(number);
			lotto.add(number);
		}while(lotto.size() < 6);
		
		
		for(int n: lotto) {
			System.out.print(n+"\t");
			
		}
		
	
		int number1;
		number1 = (int)(Math.random()*45+1);
	System.out.println("보너스번호: "+ number1);
	}
	}
