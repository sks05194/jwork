package third;

public class Wrap01 {
	public static void main(String[] args) {
		Integer i = 50;
		String s = String.valueOf(i);
		s = i.toString();
		System.out.println(s);

		double d = 50.25;
		s = String.valueOf(d);
		System.out.println(s);
	}
}