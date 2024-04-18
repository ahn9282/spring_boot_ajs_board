package edu.sejong.ex.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public UserVO getUser(String username);
	public void insertUser(UserVO userVO);
	public void insertAuthorities(UserVO userVO);
	
}
