package interfaceex;

/*
 * 변수로 입력한 값이 "사람"이라는 값과 동일하면
 * "사람입니다."라고 출력을
 * 같지 않으면 "사람이 아닙니다"라고
 * 출력이 되도록 로직을 처리하세요.
 * */

public class TestEx {
	public static void main(String[] args) {
		Test human = new Test("대머리", 81);

		distinguish(human);
		human.distinguish();

		human.setName("사람");

		distinguish(human);
		human.distinguish();
	}

	public static void distinguish(Test object) {
		String name = object.getName();

		System.out.print(name + "은(는) ");
		if (name.equals(PaTest.KIND))
			object.trueKind();
		else
			object.falseKind();
	}
}