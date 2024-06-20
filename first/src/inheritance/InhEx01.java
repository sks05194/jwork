// README 경고를 없애기 위해 일부 코드를 주석처리 하였습니다.
// 대상 코드 10~12, 18~19번줄

package inheritance;

public class InhEx01 {

	public static void main(String[] args) {
		// Object 클래스 상속을 통한 메소드 재정의
//		Class c1 = String.class;
//		System.out.println(c1);
//		System.out.println(c1.getClass());
//		c1 = "하하하"; // 오류

		String str1 = new String();
		System.out.println(str1.getClass());

//		Class c2 = str1.getClass();
//		System.out.println(c2);
	}
}