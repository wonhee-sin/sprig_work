package com.spring.setter_injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUserTest {

	public static void main(String[] args) {
		//1.Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//Spring 컨테이너를 종료한다.
		factory.close();
		/*
		 1.SamsungTV 객체가 생성될때 매개변수가 있는 생성자가 사용됨
		 2.생성자 인젝션으로 의존성 주입된 SonySpeaker가 먼저 생성됨
		  */
	}

}
