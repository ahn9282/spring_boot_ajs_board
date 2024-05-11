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
import org.springframework.security.test.context.support.WithMockUser;
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
class SecurityControllerTest {

	@Autowired
	private MockMvc mockMvc;//웹 브라우저 가져오기
	//HTTP 호출을 위한 MockMVC사용
	
	
	//DB의 데이터를 토대로 하는 것이 아닌 시뮬레이션 용 설정 주로 권한 테스트로 사용
	@WithMockUser(username="admin", password="admin", authorities = "ROLE_USER")
	@Test
	void testAdminPage()  throws Exception {
		
		//관리자 홈
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminHome"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
		
		
		}
	
	
	@WithMockUser(username="admin", password="admin", authorities = "ROLE_USER")
	@Test
	void testUserPage()  throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/user/userHome"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print());
		log.info("user권한 True");
		
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/adminHome"))
		.andExpect(MockMvcResultMatchers.status().is4xxClientError())
		.andDo(print());
		log.info("user권한 False");
		
		
	}
	
	
}
