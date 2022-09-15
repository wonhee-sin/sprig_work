package com.cloud.mapper;

import java.util.List;

import com.cloud.domain.MemberVO;

public interface MemberMapper {
	
	//ID 중복 검사
	public int checkID(String userid);
	
	//회원 조회(검색)
	public MemberVO read(String userid);
	
	//회원 가입
	public void insertMember(MemberVO member);
	
	//회원 목록
	public List<MemberVO> getMemberList();
	
	//회원 탈퇴
	public void deleteMember(MemberVO member);
	
	//회원 수정
	public void updateMember(MemberVO member);
}
