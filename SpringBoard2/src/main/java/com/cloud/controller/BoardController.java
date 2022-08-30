package com.cloud.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.domain.BoardVO;
import com.cloud.service.BoardService;

import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Controller
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/boardList")
	public String getBoardList(Model model, HttpSession session) {
		List<BoardVO> boardList = service.getBoardList();
		String id = (String)session.getAttribute("sessionId");
		model.addAttribute("boardList", boardList);
		model.addAttribute("id", id);
		return "/board/boardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoard() {
		log.info("게시글 작성");
		return "/board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(BoardVO vo) {
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) {
		service.updateCount(bno);
		BoardVO board = service.getBoard(bno);
		model.addAttribute("board", board);
		log.info("게시글 작성");
		return "/board/boardView";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		service.delete(vo);
		return "redirect:/board/boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		service.update(vo);
		return "redirect:/board/boardList";
	}
}
