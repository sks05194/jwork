package inheritance;

public class CastingTest02 {
	public static void main(String[] args) {
		Guest guest = new Guest();
//		Food foodone = new Food();
//		Food foodone = new Jjigae();
		Food foodone = new Tang();
		guest.foodEat(foodone);
	}
}

class Food {
	public void cook() {
		System.out.println("Food 간맞추기");
	}
}

class Jjigae extends Food{
	@Override
	public void cook() {
		System.out.println("Jjigae 간맞추기");
	}
}

class Tang extends Food {
	@Override
	public void cook() {
		System.out.println("Tang 간맞추기");
	}
}

class Guest {
	public void foodEat(Food somefood) {
		System.out.println("Guest 간맞추기");
		somefood.cook();
	}
}