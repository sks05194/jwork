package collectionex;

import java.util.Scanner;

public class ScannerEx00 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("0번: ");
		String s1 = sc.next();
		sc.nextLine();

		System.out.print(s1 + "\n1번: ");
		s1 = sc.nextLine();

		System.out.print(s1 + "\n2번: ");
		int i = sc.nextInt();

		System.out.print(i + "\n3번: ");
		s1 = sc.next();
		
		System.out.print(s1 + "\n4번: ");
		s1 = sc.next();
		System.out.println(s1);
		
		sc.close();
	}
}