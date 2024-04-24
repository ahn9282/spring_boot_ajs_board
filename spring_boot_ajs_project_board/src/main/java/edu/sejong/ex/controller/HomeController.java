package edu.sejong.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/user/userHome")
	public void userHome() {
		// void메서드 매핑의 경우 매핑한 url이름을 그대로 반환
		log.info("userHome()..");

	}

	@GetMapping("/admin/adminHome")
	public void adminHome() {
		log.info("adminHome()..");

	}

	/*
	 * @GetMapping("/login") public String login(Model model) {
	 * log.info("login().."); return "login/login";
	 * 
	 * }
	 */

	@GetMapping("/")
	public String hHome() {
		log.info("Home()..,");
		return "home";
	}
}
