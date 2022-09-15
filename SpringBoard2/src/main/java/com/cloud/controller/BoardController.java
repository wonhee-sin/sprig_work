package com.cloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.service.BoardService;

import lombok.Getter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Controller
@Log4j
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	@GetMapping("/boardList")
	@PreAuthorize("isAuthenticated()")
	public String getBoardList(Criteria cri, Model model) {
		
		List<BoardVO> boardList = service.getListWithPage(cri);
		int total = service.getTotalCount(cri);
		PageDTO pageMaker = new PageDTO(cri, total);
		
		log.info(cri);
		
		model.addAttribute("boardList", boardList); //view로 전송
		model.addAttribute("pageMaker", pageMaker); //"pageMaker" -> boardList.jsp
		return "/board/boardList";
	}
	
	@GetMapping("/insertBoard")
	@PreAuthorize("isAuthenticated()")
	public String insertBoard() {
		log.info("게시글 작성");
		return "/board/insertBoard";
	}
	
	@PostMapping("/insertBoard")
	@PreAuthorize("isAuthenticated()")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			String filePath = "c:/upload/";
			uploadFile.transferTo(new File(filePath + fileName));
		}
		service.insert(vo);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping("/boardView")
	public String getBoard(int bno, @ModelAttribute("cri") Criteria cri, Model model) {
		service.updateCount(bno);
		BoardVO board = service.getBoard(bno);
		
		
		model.addAttribute("board", board);
		return "/board/boardView";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		service.delete(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO vo, Criteria cri, RedirectAttributes rttr) {
		service.update(vo);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/boardList";
	}
}
