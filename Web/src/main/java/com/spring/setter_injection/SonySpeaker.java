package com.spring.setter_injection;

public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("==> SonySpeaker 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker -- 소리 올림");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker -- 소리 내림");
		
	}

}
