package abstractex;

public class AbstractEx02 {
	public static void main(String[] args) {
		Shape ref = new Circle();
		ref.draw();
	}
}

abstract class Shape {
	public abstract void draw();
}

class Circle extends Shape {
	public void draw() {
		System.out.println("원을 그리다.");
	}
}