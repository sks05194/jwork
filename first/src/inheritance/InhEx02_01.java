package inheritance;

class AA {
	int i;
	int j;

	public void setIJ(int x, int y) {
		i = x;
		j = y;
	}
}

class BB extends AA {
	int total;

	void sum() {
		total = i + j;
	}
}

public class InhEx02_01 {
	public static void main(String[] args) {
		BB subOb = new BB();

		subOb.setIJ(10, 12);
		subOb.sum();
		System.out.println("합계 : " + subOb.total);
	}
}