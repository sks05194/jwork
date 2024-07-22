package second;

class Fruits {
	private int apple;
	private int straw;
	private int grapes;
	private int sum;

	public Fruits(int apple, int straw, int grapes) {
		this.apple = apple;
		this.straw = straw;
		this.grapes = grapes;
		count();
	}

	private void count() {
		sum = apple + straw + grapes;
	}
	
	public int getApple() {
		return apple;
	}
	
	public int getStraw() {
		return straw;
	}

	public int getGrapes() {
		return grapes;
	}
	
	public int getSum() {
		return sum;
	}
}