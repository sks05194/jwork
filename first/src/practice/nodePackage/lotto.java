package practice.nodePackage;

import java.util.Set;
import java.util.TreeSet;

public class lotto {
	public static void main(String[] args) {
		Set<Integer> lottoNum = new TreeSet<Integer>();
		while (lottoNum.size() < 6)
			lottoNum.add(randNum());
		System.out.println(lottoNum);

		int plusNum;
		do {
			plusNum = randNum();
			lottoNum.add(plusNum);
		} while (lottoNum.size() < 7);
		System.out.print(plusNum);
	}
	
	public static int randNum() {
		return (int) (Math.random() * 45) + 1;
	}
}