package first;

public class Ex07 {
	public String name; // null
	public int age;
	public String phone;
	
	public Ex07() {
		name = "";
		age = 1;
		phone = "";
	}

	public Ex07(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	
	public void setName(String name) { this.name = name; }
	
	public void setAge(int age) { this.age = age; }
	
	public void setPhone(String phone) { this.phone = phone; }
}