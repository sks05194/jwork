package second;

public class This {
	int num = 1;
	String str = "한글";

	public void setNum(int num, String str) {
		this.num = num;
		this.str = str;
	}

	public int getNum() {
		return num;
	}

	public int getNum(int j) {
		this.num = num * j;
		return num;
	}

	public void amd() {
		int num = 5;
		int str = 7;
		if (num <= 5) {
			System.out.println("this.num은 " + this.num);
			System.out.println("this.str은 " + this.str);
			System.out.println("num은 " + num);
			System.out.println("str은 " + str);
		}
		System.out.println("num은 " + num);
		System.out.println("str은 " + str);
		System.out.println();
	}
}
