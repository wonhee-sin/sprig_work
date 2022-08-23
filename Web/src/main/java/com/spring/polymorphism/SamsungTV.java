package com.spring.polymorphism;

public class SamsungTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SamsungTV_전원 켠다");
		
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV_전원 끈다");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungT--소리 올린다");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV--소리 내린다");
		
	}

}
