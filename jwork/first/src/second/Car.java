package second;

public class Car {
	private String modelName;
	private int modelYear;
	private String color;
	private int maxSpeed;
	private int currentSpeed;

	Car(String modelName, int modelYear, String color, int maxSpeed) {
		this.modelName = modelName;
		this.modelYear = modelYear;
		this.color = color;
		this.maxSpeed = maxSpeed;
		this.currentSpeed = 0;
	}

	Car() {
		this("소나타", 2012, "검정색", 160);
	}

	public String getModel() {
		return this.modelYear + "년식 " + this.modelName + " " + this.color;
	}

	// 주의 나오지 않게 하기 위한 메소드
	void curSpeedSetting() {
		if (currentSpeed > maxSpeed)
			currentSpeed = maxSpeed;
	}
}
