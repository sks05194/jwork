package innerex;

class AnnonyEx03{
	void amd () {
		System.out.println("AnnonyEx03 클래스의 amd() 메소드 호출");
	}
}

public class AnnonyEx03Test {
	public static void main(String[] args) {
		AnnonyEx03 ac3=new AnnonyEx03() {
			@SuppressWarnings("unused")
			int c = 5;

			@SuppressWarnings("unused")
			void cmd() {
				System.out.println("익명클래스의 cmd() 메소드");
			}
		};
		ac3.amd();
//		ac3.cmd();
	}
}