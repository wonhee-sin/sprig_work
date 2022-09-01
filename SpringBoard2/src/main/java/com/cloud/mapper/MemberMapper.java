package com.cloud.mapper;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	//회원 조회(검색)
	public MemberVO read(String userid);
	
	//회원 가입
	public void insertMember(MemberVO member);
}
