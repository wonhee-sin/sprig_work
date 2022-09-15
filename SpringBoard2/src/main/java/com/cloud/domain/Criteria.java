package com.cloud.domain;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;
	private int amount;
	
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//타입을 저장할 메서드 정의(Type이 null이 아니면 문자열을 분리하여 배열로 반환)
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
