package com.cloud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cloud.domain.UserVO;
import com.cloud.service.UserService;

@Controller
public class UserController {

		@Autowired
		private UserService service;
		
		@GetMapping("/login")
		public String loginView() {
			return "login";
		}
		
		@PostMapping("/login")
		public String login(UserVO vo, HttpSession session, Model model) {
			boolean result = service.login(vo);
			System.out.println(result);
			if(result == true) {
				session.setAttribute("sessionId", vo.getId());
				return "redirect:/board/boardList";
			}else {
				int error = 1;
				model.addAttribute("error", error);
				return "login";
			}
		}
		
		@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "index";
		}
}
