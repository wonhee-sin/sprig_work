package com.spring.ploymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUserTest {

	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		
		//Spring 컨테이너 종료
		factory.close();
	}

}
