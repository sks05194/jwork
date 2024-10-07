package com.springbook.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("sony")
@Primary
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> SonySpeaker 객체 생성");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker---소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker---소리를 내린다.");
	}
}