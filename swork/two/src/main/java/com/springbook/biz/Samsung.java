package com.springbook.biz;

public class Samsung implements TV {
	private Speaker speaker;
	private int price;

	public Samsung() {
		System.out.println("===> SamsungTV() 객체 생성");
	}

	public Samsung(Speaker speaker) {
		System.out.println("===> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}

	public Samsung(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.printf("SamsungTV---전원을 켠다. (가격: %,d원) \n", price);
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumnUp();
		System.out.println("SamsungTV---소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		speaker.volumnDown();
		System.out.println("SamsungTV---소리를 내린다.");
	}
}