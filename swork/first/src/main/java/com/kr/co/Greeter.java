package com.kr.co;

public class Greeter {
	private String format;
	private String str;

	public Greeter(String str) {
		System.out.println("Greeter" + str + " 생성자 호출");
	}

	public String greet(String guest) {
		this.str = String.format(format, guest);
		return str;
	}
	
	public String getStr() {
		return str;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}