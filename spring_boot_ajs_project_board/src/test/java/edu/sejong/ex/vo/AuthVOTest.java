package edu.sejong.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootTest
class AuthVOTest {

	@Test
	void test() {
		AuthVO authVO = new AuthVO();
		
		assertNotNull(authVO);
	}
	
	@Test
	void testGetUsername() {
		AuthVO authVO = new AuthVO();
		authVO.setUsername("홍길동");
		
		assertNotNull(authVO);
		assertEquals(authVO.getUsername(), "홍길동");
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	@DisplayName("커넥션 풀 테스트")
	void testConnectionPool() throws SQLException {
		log.info("커넥션풀 테스트..");
		log.info("DS = {}", dataSource);
		log.info("GetConnection!! {}", dataSource.getConnection());
	}
}
