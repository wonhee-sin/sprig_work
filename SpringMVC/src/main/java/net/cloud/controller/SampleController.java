package net.cloud.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;
import net.cloud.domain.SampleVO;


@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {
	// http://localhost:8080/sample/basic - jsp파일이 없어서 404에러 뜸
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public void basic() {
		log.info("basic get........");
	}
	
	@GetMapping("/basicGet")
	public void basicGet() {
		log.info("basic get only get..............");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleVO vo) {
		log.info("" + vo);
		return "ex01";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex03")
	public String ex03(SampleVO vo, @ModelAttribute("page") int page) {
		log.info("vo: " + vo);
		log.info("page: " + page);
		return "ex03";
	}
}
