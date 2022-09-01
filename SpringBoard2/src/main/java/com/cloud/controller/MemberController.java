package com.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String signUp(MemberVO member, RedirectAttributes rttr) {
		service.signup(member);
		return "redirect:/board/boardList";
	}
}
