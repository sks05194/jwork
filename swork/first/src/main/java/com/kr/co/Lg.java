package com.kr.co;

public class Lg implements TV {
	public Lg() {
		System.out.println("LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() { System.out.println("Lg 전원 켜기"); }

	@Override
	public void powerOff() { System.out.println("Lg 전원 끄기"); }

	@Override
	public void volumeUp() { System.out.println("Lg 볼륨 올리기"); }

	@Override
	public void volumeDown() {System.out.println("Lg 볼륨 낮추기"); }
}