package innerex;

interface Ramda2 {
	public static final int a = 5;

	public abstract void makeString(String s1, String s2);
}

public class RamdaEx02 {
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Java";
		@SuppressWarnings("unused")
		int b = 1;
		Ramda2 concat = (s, v) -> System.out.println(s + ", " + v + Ramda2.a);
		System.out.println(concat.hashCode());
//		Ramda2 concat = new Ramda2() {
//			@Override
//			public void makeString(String s1, String s2) {
//				System.out.println(s1 + ", " + s2 + a); // 자동 상속처리
//			};
//		};
		concat.makeString(s1, s2);
	}
}