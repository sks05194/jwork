package innerex;

@FunctionalInterface
interface Ramda01 {
	int getMax(int num1, int num2);
//	int add(int num1, int num2);
}

public class RamdaEx01 {
	public static void main(String[] args) {
		Ramda01 max = (num1, num2) -> {
			System.out.println("람다식 실행");
			return 5;
		};
		// 람다식을 인터페이스형 max 변수에 대입
		max = (x, y) -> (x >= y) ? x : y;
//		정식 형식:
//		Ramda01 max = new Ramda01() {
//			@Override
//			public int getMax(int x, int y) {
//				return (x >= y) ? x : y;
//			}
//		};
		int r = max.getMax(10, 20);
		// 인터페이스형 변수로 메소드 호출
		System.out.println(r);

		max = (x, y) -> x * y;
		r = max.getMax(10, 20);
		System.out.println(r);
	}
}