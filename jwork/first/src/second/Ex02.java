package second;

//같은 패키지 안에는 동일한 이름의 클래스(=자료형)를 만들 수 없다.
public class Ex02 {

	public static void main(String[] args) {
		String s = new String("빨간불");
		String s1 = "빨간불";
		
		System.out.println(s == s1 ? "빨간불입니다." : "빨간불이 아닙니다.");
		System.out.println(s.equals(s1) ? "빨간불입니다." : "빨간불이 아닙니다.");
	}
	
	public void printClass() {
		System.out.println("second 패키지 내의 Ex02 클래스입니다.");
	}
}