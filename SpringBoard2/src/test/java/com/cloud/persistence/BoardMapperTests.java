package com.cloud.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloud.domain.BoardVO;
import com.cloud.domain.Criteria;
import com.cloud.domain.PageDTO;
import com.cloud.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	/*@Test
	public void testGetList() {
		List<BoardVO> list = mapper.getBoardList();
		
		list.stream()
			.map(board-> board.getBno())
			.forEach(board -> log.info(board));
	}
	*/
	/*	@Test
		public void testPaging() {
			Criteria cri = new Criteria();
			
			cri.setPageNum(3);
			cri.setAmount(10);
			
			List<BoardVO> list = mapper.getListWithPage(cri);
			
			list.stream().map(board -> board.getBno()).forEach(board -> log.info(board));
		}*/
	
	/*	@Test
		public void testPageDTO() {
			Criteria cri = new Criteria();
			cri.setPageNum(2);
			
			PageDTO page = new PageDTO(cri, 61);
			log.info(page);
		}*/
	
	/*		@Test
			public void testSearch() {
				Map<String, String> map = new HashMap<>();
				map.put("W", "member87");		
				
				//중첩 Map 사용
				Map<String, Map<String, String>> outer = new HashMap<>();
				outer.put("map", map);
				
				List<BoardVO> list = mapper.searchTest(outer);
				
				log.info(list);
			}*/
	
			@Test
			public void testSearchPaging() {
				Criteria cri = new Criteria();
				cri.setType("TC");
				cri.setKeyword("번");
				
				List<BoardVO> list = mapper.getListWithPage(cri);
				
				list.forEach(board -> log.info(board));
			}
}
