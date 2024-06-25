package interfaceex;

interface PaTest {
	String KIND = "사람";

	void trueKind();

	void falseKind();
}

public class Test implements PaTest {
	private String name;
	private int age;

	public Test() {

	}

	public Test(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public void trueKind() {
		System.out.println(KIND + "입니다.");
	}

	@Override
	public void falseKind() {
		System.out.println(KIND + "이 아닙니다.");
	}
	
	void distinguish() {
		System.out.print(name+ "은(는) ");
		if (name == PaTest.KIND)
			trueKind();
		else
			falseKind();
	}
}