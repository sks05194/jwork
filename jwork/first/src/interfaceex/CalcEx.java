package interfaceex;

public class CalcEx {
	public static void main(String[] args) {
		Calc c = new CalcCha1();
		c.add(5, "덧셈");
		c.minus(5);
		c.multi(5);
		c.divi(3);

		Calc c1 = new CalcCha2();
		c1.add(5, "덧셈");
		c1.minus(5);
		c1.multi(5);
		c1.divi(3);
	}
}