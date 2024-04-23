package edu.sejong.ex.mapper;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.sejong.ex.vo.AuthVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	UserMapper userMapper;

	@Disabled
	@Test
	void getUserTest() {
		UserVO userA = userMapper.getUser("admin");
		log.info("{}", userA.getAuthList());
		for (AuthVO s : userA.getAuthList()) {
			log.info("{}", s);
		}
	}

	@Disabled
	@Test
	void getInserTest() {
		UserVO user = new UserVO();
		user.setUsername("qqwwqq");
		user.setPassword("1234");
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
		UserVO userA = userMapper.getUser(user.getUsername());
		log.info("{}", userA.getAuthList());
		for (AuthVO s : userA.getAuthList()) {
			log.info("{}", s);
		}
	}
	//@Disabled
	@Test
	void testInsertUser() {
		UserVO user = new UserVO();
		user.setUsername("admin2");
		user.setPassword(new BCryptPasswordEncoder().encode("admin2"));
		user.setEnabled("1");	
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
		
	}
	@Test
	void testInsertUserAdmin() {
		UserVO user = new UserVO();
		user.setUsername("admin3");
		user.setPassword(new BCryptPasswordEncoder().encode("admin3"));
		user.setEnabled("1");	
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
		
	}
}
