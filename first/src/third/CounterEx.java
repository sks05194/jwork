package third;

public class CounterEx {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		
		System.out.println(Counter.getCount());
		System.out.println(c1.getCount());
		System.out.println(c2.getCount());
	}
}