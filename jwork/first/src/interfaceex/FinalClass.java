package interfaceex;

class FinalClass {
	private static String modelName = "Mustang";

	public static void main(String[] args) {
		Vehicle myFastCar = new Vehicle();
		myFastCar.cmd();
		myFastCar.vmd();
		System.out.println(myFastCar.brand + " " + modelName);
	}
}

final class Mashin {
	public void mmd() {
		System.out.println("Mashin 클래스 메소드");
	}
}

// class Car extends Mashin { }
class Car1 {
	public void cmd() {
		System.out.println("Car 클래스 메소드");
	}

	public final void cmd1() {
		System.out.println("Car 클래스 final 메소드");
	}
}

class Vehicle extends Car1 {
	protected String brand = "Ford";

	public void vmd() {
		System.out.println("Vehicle 클래스 메소드");
	}

	@Override
	public void cmd() {
		System.out.println("Car 클래스 메소드를 Vehicle 클래스에서 재정의한 메소드");
	}

//	@Override
//	public final void cmd1() {
//		System.out.println("Car 클래스 final 메소드를 Vehicle 클래스에서 재정의한 메소드");
//	}
}