package first;

public class Test {
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
		String[] sub = { "국어", "영어", "수학" };
		int[] score = { 80, 90, 95 };
		int total = 0;

		for (int i = 0; i < sub.length; i++) {
			System.out.printf("%s 점수 : %d %n", sub[i], score[i]);
			total += score[i];
		}

		println("총점은 : " + total);
		System.out.printf("평균은 : %.2f\n", (float) total / score.length);

		// 이하 TestM
		TestM tm = new TestM();
		println("총점은 : " + tm.getTotal());
		System.out.printf("평균은 : %.2f\n", tm.getAVG());
		tm.result();
	}
}
