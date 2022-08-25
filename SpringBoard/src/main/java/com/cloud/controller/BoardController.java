package com.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloud.repository.BoardVO;
import com.cloud.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardList")
	public String getBoardList(Model model) {
		List<BoardVO> boardList = service.getBoardList();
		model.addAttribute("boardList",boardList);
		return "boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, Model model) {
		service.updateCount(bno); //조회수 증가
		BoardVO board = service.getBoard(bno); //상세보기 처리
		model.addAttribute("board",board);
		return "boardView";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.GET)
	public String insertBoard() {
		return "insertBoard";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		service.insert(vo);
		return "redirect:boardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		service.delete(vo);
		return "redirect:boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo) {
		service.update(vo);
		return "redirect:boardList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
