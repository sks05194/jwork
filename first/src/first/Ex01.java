package first;

public class Ex01 {
	public static void hello_func1() {
		System.out.println("Hello World!");
	}
	
	public static String hello_func2() {
		return "Hello World!";
	}
	
	public static void main(String[] args) {
		
		
		// 바로 출력
		System.out.println(hello_func2());
		
		// 변수로 출력
		String hello = hello_func2();
		System.out.println(hello);
	}
}