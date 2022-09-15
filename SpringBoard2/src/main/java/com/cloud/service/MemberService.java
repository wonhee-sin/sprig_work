package com.cloud.service;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberService {
	
	//ID 중복 검사
	public int checkID(String userid);
	
	//회원 가입
	public void signup(MemberVO member);
	
	public List<MemberVO> getMemberList();	//회원 목록
	
	public MemberVO read(String userid);	//회원 상세보기
	
	public void delete(MemberVO member);
	
	public void update(MemberVO member);
	
}
