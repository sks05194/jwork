package inheritance;

public class InhEx01 {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// Object 클래스 상속을 통한 메소드 재정의
		Class c1 = String.class;
		System.out.println(c1);
		System.out.println(c1.getClass());
//		c1 = "하하하"; // 오류

		String str1 = new String();
		System.out.println(str1.getClass());

		Class c2 = str1.getClass();
		System.out.println(c2);
	}
}