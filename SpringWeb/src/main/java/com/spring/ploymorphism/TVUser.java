package com.spring.ploymorphism;

public class TVUser {

	public static void main(String[] args) {
		TV tv = new SamsungTV();  //SamsungTV()�� ��ü 
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		/*
		  �������̽��� ��ü(�ν��Ͻ�)�� �����ϰ� ������ ����ȯ(�ڵ�����ȯ)��
		  �̿��Ͽ� ��ü�� �����ϸ� ���� ��ü ����
		 */
	}

}
