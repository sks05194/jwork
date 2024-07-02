package lottos;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// 777회차 로또 당첨번호 : 00, 00, 00, 00, 00, 00 + [보너스 번호] 00

public class Lotto_강동준 {
	public static void main(String[] args) {
		Set<Integer> lottoNum = new TreeSet<Integer>();
		
		while (lottoNum.size() < 6)
			lottoNum.add(randNum());

		printLottoNum(lottoNum);

		int plusNum;
		do {
			plusNum = randNum();
			lottoNum.add(plusNum);
		} while (lottoNum.size() < 7);
		System.out.print(" + [보너스 번호] " + plusNum);
	}

	public static int randNum() {
		return (int) (Math.random() * 45) + 1;
	}

	public static void printLottoNum(Collection<Integer> lottoNum) {
		System.out.print("777회차 로또 당첨번호 : ");

		StringBuffer str = new StringBuffer();
		Iterator<Integer> lottoNums = lottoNum.iterator();
		while (lottoNums.hasNext())
			str.append(lottoNums.next() + ", ");
		str.setLength(str.length() - 2);

		System.out.print(str);
	}
}