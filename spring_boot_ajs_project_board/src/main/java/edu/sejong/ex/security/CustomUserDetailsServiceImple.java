package edu.sejong.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.JoinMapper;
import edu.sejong.ex.mapper.UserMapper;
import edu.sejong.ex.vo.EmpUserDetailsVO;
import edu.sejong.ex.vo.EmpVO;
import edu.sejong.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsServiceImple implements UserDetailsService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private JoinMapper JoinMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.warn("Load User By EmpVO member : {}", username);


		EmpVO emp = JoinMapper.getEmpVO(username);

		log.warn("queried by UserVO mapper : {}", emp);

		return emp == null ? null : new EmpUserDetailsVO(emp);

	}
	/*
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException {
	 * 
	 * log.warn("Load User By UserVO member : {}", username);
	 * 
	 * UserVO user = userMapper.getUser(username);
	 * 
	 * EmpVO empVO = JoinMapper.getEmpVO("KING");
	 * 
	 * log.warn("queried by UserVO mapper : {}", user);
	 * 
	 * return user==null?null:new UserDetailsVO(user, empVO);
	 * 
	 * }
	 */

}
