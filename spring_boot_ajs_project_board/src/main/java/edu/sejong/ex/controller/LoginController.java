package edu.sejong.ex.controller;

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
}
