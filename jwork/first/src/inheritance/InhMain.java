package inheritance;

public class InhMain {
	public static void main(String[] args) {
		A b = new B();
		b.paint();
		b.draw();
	}
}

class A {
	public void paint() {
		System.out.print("A");
		draw();
	}

	public void draw() {
		System.out.println("B");
		draw();
	}
}

class B extends A {
	public void paint() {
		super.draw();
		System.out.print("C");
		this.draw();
	}

	public void draw() {
		System.out.println("D");
	}
}