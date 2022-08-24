package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.vo.FriendVO;
import com.spring.vo.FriendVO2;

@Service
public class HomeService {
	
	public void sayHello() {
		//System.out.println("안녕하세요~");
		FriendVO vo1 = new FriendVO();
		vo1.setName("안산");
		vo1.setAge(21);
		
		FriendVO2 vo2 = new FriendVO2("안영이", 31);
		
		System.out.println(vo1.getName() +"("+vo1.getAge() + ")" + "님 안녕하세요~");
		
		System.out.println(vo2.getName() +"("+vo2.getAge() + ")" +"님 안녕하세요~");
	}
}
