package innerex;

public class InnerEx02 {
	private int data = 30;

	void display() {
		class Local { // 지역 이너클래스
			public int b = 5;

			void msg() {
				System.out.println(data);
				display2();
			}
		}
		Local l = new Local();
		l.msg();
		System.out.println(l.b);
	}

	class InstanceInner {
		int iv = 100;

		void myMethod() {
			display();
//			msg();
			System.out.println("InstanceInner 클래스의 메소드 data : " + data + ", iv: " + iv);
		}
	}

	void display2() {
		System.out.println("display2() 메소드 호출");
	}

	public static void main(String[] args) {
		InnerEx02 obj = new InnerEx02();
		obj.display();
		InnerEx02.InstanceInner obj1 = obj.new InstanceInner();
		obj1.myMethod();
	}
}