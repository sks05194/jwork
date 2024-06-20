package third;

public class Singleton {
	private static Singleton Instance;

	public static Singleton getInst() {
		if(Instance == null) Instance = new Singleton();
		return Instance;
	}

	private Singleton() {}
}