package third;

public class Counter {
	static int count = 0;

	Counter() {
		count++;
	}

	public static int getCount() {
		return count;
	}
}