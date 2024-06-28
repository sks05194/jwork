package exceptex;

public class ExceptEx00 {
	public static void main(String[] args) {
		try {
//			Class c = String.class;
			@SuppressWarnings("rawtypes")
			Class c = Class.forName("String"); // 오류남
//			Class c = Class.forName("java.lang.String"); // 오류가 나지 않음
			System.out.println("출력결과: " + c);
		} catch (Exception e) {
			System.out.println("에러정보: " + e);
		}
		System.out.println("시스템 정상 종료");
	}

//	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
//		Class c1 = Class.forName("String");
//		System.out.println(c1);
//	}
}