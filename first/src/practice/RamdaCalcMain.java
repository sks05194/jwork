package practice;

interface IRamdaCalc<T extends Number> {
	T calc(T a, T b);
}

public class RamdaCalcMain {
	public static void main(String[] args) {
		IRamdaCalc<Integer> add = (a, b) -> a + b;
		IRamdaCalc<Integer> sub = (a, b) -> a - b;
		IRamdaCalc<Long> mul = (a, b) -> a * b;
		IRamdaCalc<Double> div = (a, b) -> a / b;
		IRamdaCalc<Integer> mod = (a, b) -> a % b;
//		RamdaCalcInterface<String> concat = (a, b) -> a + b; // String은 Number를 상속받지 못하였으므로 오류가 발생한다.
		
		System.out.println(add.calc(10, 20));
		System.out.println(sub.calc(30, 10));
		System.out.println(mul.calc(200L, 500L));
		System.out.println(div.calc(20.0, 2.5));
		System.out.println(mod.calc(20, 7));
	}
}