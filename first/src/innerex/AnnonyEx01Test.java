package innerex;

public class AnnonyEx01Test {
	public static void main(String[] args) {
		int aa = 5;
		@SuppressWarnings("unused")
		final int AA = 7;

		AnnonyEx01Abstract myClass = new ASub() {
			private int a = 15;
			String s = "AnnonymousClass";
			final int AA = 0;

//			static final int AA = 0;
//			static int st = 0;

			@Override
			public void doSomething() {
//				aa = a + aa;
				super.doSomething();
				System.out.println("내부 익명 클래스의 doSomething 메소드");

				System.out.println("s : " + s);
				System.out.println("a : " + a);
				System.out.println("aa : " + aa);
				System.out.println("AA : " + AA);

				etcMethod();
			}

			public void etcMethod() {
				System.out.println("기본 메소드입니다.");
			}
		}; // 객체생성문 종료

		myClass.doSomething();
//		myClass.etcMethod();
//		aa = aa + 15;

		System.out.println("aa: " + aa);
//		System.out.println(myClass.s);
	}
}

abstract class AnnonyEx01Abstract {
	public String s;

	public abstract void doSomething();
}

class ASub extends AnnonyEx01Abstract {
	@Override
	public void doSomething() {
		System.out.println("ASub클래스 doSomething()메소드 호출");

	}
}