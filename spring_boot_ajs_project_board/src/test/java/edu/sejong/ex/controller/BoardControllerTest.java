package edu.sejong.ex.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.sejong.ex.page.Criteria;
import lombok.extern.slf4j.Slf4j;

//
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {

	@Autowired
	private MockMvc mockMvc;//웹 브라우저 가져오기
	//HTTP 호출을 위한 MockMVC사용
	
	@Disabled
	@Test
	void testHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	@Disabled
	@Test
	void testHelloBoard() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	@Test
	void testHelloBoardCriteria() throws Exception {
		Criteria criteria = new Criteria();
		criteria.setPageNum(2);
		criteria.setAmount(10);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list2").queryParam("pageNum", "2").queryParam("amount", "10"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
	}
	
}
