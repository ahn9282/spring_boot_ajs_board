package edu.sejong.ex.vo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.page.Criteria;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class PageVOTest {

	@Autowired
	private BoardMapper BoardMapper;
	
	
	@Test
	void testPageVO() {
		assertNotNull(BoardMapper);
		
	}

	@Test
	void testPaging() {
		Criteria cri = new Criteria();
		assertNotNull(cri);
		
		List<BoardVO> list = BoardMapper.getListWithPaging(cri);
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
				
	}
}
