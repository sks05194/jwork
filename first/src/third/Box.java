package third;

public class Box {
	long idNum;
	static long boxID = 0;
	
	public Box() {
		idNum = boxID++;
	}
}