package interfaceex;

public interface A {
	final int CONS = 5; // public static final

	public void display(String s); // public abstract

	void imd(); // public abstract

	// 원래 public default임. 접근제어자의 default가 아닌 몸체를 가질 수 있는 메소드임.
	default void dfmd(String str) {
		System.out.println("A인터페이스 안의 dfmd 메소드의 str 변수 값: " + str + "와 CONS의 값: " + CONS);
	}

	static int stmd(int c) {
		return CONS + c;
	}
	
	@SuppressWarnings("unused")
	private void pmd() {
		System.out.println("A인터페이스 안의 pmd");
	}
}