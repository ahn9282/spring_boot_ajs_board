package edu.sejong.ex.service;


import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.UserVO;
@Service
public interface UserService  {

	public void insertUser(UserVO user);
}