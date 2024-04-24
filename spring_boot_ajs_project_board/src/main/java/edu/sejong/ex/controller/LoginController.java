package edu.sejong.ex.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	
	@GetMapping("/login")
	public String login(Model model) {
		log.info("login()..");
		return "login/login";
	}
	
	@GetMapping("/loginInfo")
	public void loginInfo(Principal principal, Authentication authentication, Model model) {
		log.info("loginInfo()..");
		
		//1. 로그인 정보를 체크하는 첫 번째 방법 - Principal 객체를 갖고 오는 방법
		if(principal != null) {
			log.info("타입정보 : " + principal.getClass());
			log.info("ID정보 : " + principal.getName());
		}
		
		
		//2.로그인 정보를 체그하는 두 번째 방법 - Authentication authentication 객체를 갖고 오는 방법
		if(authentication != null) {
			log.info("타입 정보 : {}", authentication.getClass());
			
			UserDetails user = (UserDetails) authentication.getPrincipal();
			log.info("getAuthorities : {}",authentication.getAuthorities());
			log.info("getDetails : {}",authentication.getDetails());
			log.info("getClass : {}",authentication.getClass());
			log.info("getPrincipal : {}",authentication.getPrincipal());
			
			WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
			
			log.info("세션 ID : {}",web.getSessionId());
			log.info("접속 IP: {}",web.getRemoteAddress());
		}
		
		//3. SpringContextHolder를 가져오기
	
		UserDetails user =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		if(user != null) {
			log.info("패스워드 : {}",user.getPassword());
			log.info("아이디 : {}",user.getUsername());
			log.info("권한들 : {}",user.getAuthorities());
		}
	}
	
		
}
