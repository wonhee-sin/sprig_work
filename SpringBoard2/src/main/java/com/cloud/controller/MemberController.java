package com.cloud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.domain.MemberVO;
import com.cloud.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@AllArgsConstructor
@Log4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	private MemberService service; 
	
	@GetMapping("/signup")
	public void signUp() {
		log.info("회원 가입 폼");
	}
	
	@PostMapping("/signup")
	public String signUp(MemberVO member) {
		service.signup(member);
		return "redirect:/board/boardList";
	}
	
	@GetMapping("memberList")
	@PreAuthorize("isAuthenticated()")
	public String getMemberList(Model model) {
		List<MemberVO> memberList = service.getMemberList();
		model.addAttribute("memberList", memberList);
		return "/member/memberList";
	}
	
	@GetMapping("/memberView")
	public String read(String userid, Model model) {
		MemberVO member = service.read(userid);
		model.addAttribute("member", member);
		return "member/memberView";
	}
	
	@PostMapping("/update")
	public String update(MemberVO member) {
		service.update(member);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(MemberVO member, HttpSession session) {
		session.invalidate();
		
		service.delete(member);
		return "redirect:/";
	}
	
	@RequestMapping("/checkID")
	@ResponseBody
	public int checkID(String userid) {
		int result = service.checkID(userid);
		return result;
	}
	
	
}
