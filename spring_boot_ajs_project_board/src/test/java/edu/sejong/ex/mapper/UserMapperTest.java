package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.sejong.ex.vo.AuthVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

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



	@Disabled

	@Test
	void testInsertUser() {
		UserVO user = new UserVO();
		user.setUsername("admin2");
		user.setPassword(passwordEncoder.encode("admin2"));
		user.setEnabled("1");

		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);

	}
	@Disabled
	@Test
	@DisplayName("user2추가")
	void testInsertUser2() {
		UserVO user = new UserVO();
		user.setUsername("user2");
		user.setPassword(passwordEncoder.encode("user2"));
		user.setEnabled("1");

		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);

	}

	@Disabled
	@Test
	void testInsertUserAdmin() {
		UserVO user = new UserVO();
		user.setUsername("admin3");
		user.setPassword(passwordEncoder.encode("admin3"));
		user.setEnabled("1");

		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);

	}
	
	@Test
	void testMatcher() {
		UserVO user = userMapper.getUser("admin2");
		boolean isMatch = passwordEncoder.matches("admin2",user.getPassword());
		boolean isMatch1 = passwordEncoder.matches("admin2","$2a$10$oshcz4OCovZRBq9Beisb1.mQxwBSKg.21PL5aUJkb2YuLyLkTEmOK");
		assertEquals(isMatch, true);
		assertEquals(isMatch1, true);
	}
}
