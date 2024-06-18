package second;

public class FruitsEx {
	public static void main(String[] args) {
		int total;

		Fruits f1 = new Fruits(30, 30, 30);
		total = f1.getSum();

		System.out.println("객체 f1의 총 개수 = " + total);
		System.out.println("객체 f1의 apple 개수 = " + f1.getApple());
		System.out.println("객체 f1의 straw 개수 = " + f1.getStraw());
		System.out.println("객체 f1의 grapes 개수 = " + f1.getGrapes());
	}
}