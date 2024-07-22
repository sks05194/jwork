package second;

public class MyDate {
	private int y, m, d;
	private String str;

	private void setMyDate(int r) {
		str = (r == 1) ? "유효한 날짜입니다." : "유효하지 않은 날짜입니다.";
	}

	public String getMyDate() { return str; }

	MyDate(int d, int m, int y) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

	public void isValid() {
		int r;

		switch (m) {
		case 2:
			r = (y % 4 == 0) ? ((d <= 29) ? 1 : 0) : ((d <= 28) ? 1 : 0);
			break;
		case 4: case 6: case 9: case 11:
			r = d <= 30 ? 1 : 0;
			break;
		default:
			r = d <= 31 ? 1 : 0;
		}
		setMyDate(r);
	}
}
