package exceptex;

public class ExceptEx08 {
	public static void main(String[] args) {
		try {
			System.out.println("try문 시작");
			findClass();
			System.out.println("try문 종료");
		} catch (Exception e) {
			System.out.println("클래스가 존재하지 않습니다.");
			System.out.println("에러 사유: " + e);
		}
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public static void findClass() throws ClassNotFoundException {
		System.out.println("findClass 메소드 실행");
//		Class clazz = Class.forName("java.lang.String");
		Class clazz = Class.forName("java.lang.WowClass");
	}
}