package inheritance;

public class Super01 {
	public static void main(String[] args) {
		Ch3 d = new Ch3();
		d.getX();
		d.getChX();
		d.write();
	}
}

class Pa3 {
	int x = 1000;

	void display() {
		System.out.println("상위클래스 display()");
	}

	int getX() {
		return x;
	}
}

class Ch3 extends Pa3 {
	int x = 2000;

	Ch3() {
		super.x = 5000;
	}

	@Override
	void display() {
		System.out.println("하위클래스 display()");
	}

	void write() {
		super.display();
		this.display();

		System.out.println("super.x : " + super.x);
		System.out.println("this.x : " + x);
	}

	int getChX() {
		return x;
	}
}