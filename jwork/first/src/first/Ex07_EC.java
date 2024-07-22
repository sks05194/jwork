package first;

public class Ex07_EC {
	public static void main(String[] args) {
//		Ex07 e = null;
		Ex07 e = new Ex07();
		System.out.println(e);
		System.out.println(e.name);
		
		e.setName("강동준");
		System.out.println(e.name);
		
		e.age = 27;
		System.out.println(e.age);
	}
}
