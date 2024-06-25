package generic_003_method2;

public class CompareMethosExample {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");

		boolean result1 = Util.compare(p1, p2);
//		boolean result1 = Util.<Integer, String>compare(p1, p2);

		System.out.println("논리적으로 동등" + (result1 ? "한" : "하지 않는") + " 객체입니다.");

		Pair<String, String> p3 = new Pair<String, String>("user1", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("user2", "홍길동");

		boolean result2 = Util.compare(p3, p4);
		System.out.println("논리적으로 동등" + (result2 ? "한" : "하지 않는") + " 객체입니다.");
	}
}