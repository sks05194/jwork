package first;

public class Point01Ex {
	public static void main(String[] args) {
		Point01 pt01 = new Point01();
		pt01.x = 10;
		pt01.y = 20;
		System.out.println(pt01.x + ", " + pt01.y);
		
		Point01 pt02 = new Point01();
		pt01.x = 30;
		pt01.y = 10;
		System.out.println(pt01.x + ", " + pt01.y);
		System.out.println(pt02.x + ", " + pt02.y);
	}
}