package lottos;

import java.util.*;

public class Lotto_임성현 {
	
	public static void main(String[] args) {	
		HashSet<Integer> has = new HashSet<Integer>();	
		Scanner sc = new Scanner(System.in);
		int i = 0; 
		int f = 0; 
		System.out.println("6개 번호를 중복되지 않게 한 개씩 입력하세요. :");
		while(true) {
			if(sc.hasNextInt()) {
				i = sc.nextInt();
				has.add(i);
			}else { System.out.println("숫자가 아닙니다. 다시 입력하세요."); break;}
			
			if(has.size() == 6) { break; } 
		}
		System.out.println("보너스 번호를 입력하세요. :");
		f = sc.nextInt();
		
		System.out.println("입력한 번호: " + has);
		System.out.println("입력한 보너스 번호: " + "[" + f +"]");
		
		int count = 0; 
		int r = 0; 
		HashSet<Integer> set = new HashSet<Integer>();	
		while (set.size() < 7) {
		Integer number = (int)(Math.random() * 44) + 1;
		set.add(number);
		}	
		
		Iterator<Integer> iter = set.iterator();

		while(iter.hasNext()) {
			r = iter.next(); 
		}
		System.out.print("당첨번호는 : ");
		for(int get : set) {
			System.out.print(get + " ");
		}
		System.out.println();
		System.out.println("보너스번호는 : " + r);
		Integer[] a = set.toArray(new Integer[0]); 
		Integer[] b = has.toArray(new Integer[0]);

		for(int d : a) {
			for(int e = 0; e <= 5; e++) {
				if(d == b[e]) {
					count++;
				}
			}
		
		}
		
		if(count <= 2) {
			System.out.println("꼴등입니다");
		}
		else if(count == 3) {
			System.out.println("5등입니다.");
		}
		else if(count == 4) {
			System.out.println("4등입니다.");
		}
		else if(count == 5) {
			if(f == r) {
				System.out.println("2등입니다.");
			}
		}
		else if(count == 5) {
			System.out.println("3등입니다.");
		}
		else if(count == 6) {
			System.out.println("1등입니다.");
		}
		
		sc.close();
	}
}

