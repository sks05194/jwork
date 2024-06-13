package first;

import java.util.Arrays;

public class Test1 {
	// 출력 대체코드
	public static void println(Object obj) {
		System.out.println(obj);
	}

	public static void print(Object obj) {
		System.out.print(obj);
	}

	public static void println() {
		System.out.println();
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 4, 5, 6, 7 };
		println(array);

		// for 콜론문
		for (int k : array)
			print(k + " ");
		println();

		// Arrays 이용
		println(Arrays.toString(array));
	}
}
