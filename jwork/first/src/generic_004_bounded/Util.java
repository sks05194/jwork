package generic_004_bounded;

public class Util {
	// 자식, 자손이 될 수 있는 자료형 클래스 extends 조상클래스나 인터페이스
	public static <T extends Ancestor> void boundType(T t1) {
		t1.ancestor();
	}
}