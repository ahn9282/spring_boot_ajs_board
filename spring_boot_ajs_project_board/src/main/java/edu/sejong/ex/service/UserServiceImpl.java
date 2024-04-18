package edu.sejong.ex.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public void insertUser(UserVO user) {
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}
	

}
