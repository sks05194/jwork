package lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto_김정혜 {

	public static void main(String[] args) {
		//로또번호
		Set<Integer> set = new HashSet<Integer>(); //순서없음(중복없음)
		Random random = new Random(); //랜덤숫자
		int bonus = 0; //보너스 숫자
		
		System.out.print("130 회차 로또 당첨번호 : ");
		
		while(set.size() != 6) { //총 6개의 중복없는 숫자 담김
			set.add(random.nextInt(45)+1);
		}		
		ArrayList<Integer> arrays = new ArrayList<Integer>(set); //순서없는 Set을 순서있는 ArrayList로 바꿈
		 //ArrayList 오름차순
		Collections.sort(arrays);
		for(int i =0; i<arrays.size();i++)  //arrays.size()==6
			System.out.print(arrays.get(i) + " ");			
		
		
		// 보너스 번호가 기존 배열 내 6개 값과 다른값이면 반복문 탈출
		while(true) {
			bonus = (random.nextInt(45)+1);
			if(!arrays.contains(bonus)) break;
		}
		System.out.print("+ [보너스 번호] : " + bonus);
	}

}


