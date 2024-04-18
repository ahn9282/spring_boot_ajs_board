package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.EmpService;
import edu.sejong.ex.service.UserService;
import edu.sejong.ex.vo.UserVO;


@Controller
@RequestMapping("/shopper")
public class EShopperController {
	
	@Autowired
	EmpService empService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String empJoinSalList(Model model) {
		model.addAttribute("emps",empService.empSalList());
		return "shopper/index";
	}
	@GetMapping("/login")
	public String empGoLogin() {
		return "shopper/login";
	}
	
	@PostMapping("/insertUser")
	public String loginUser(UserVO user) {
		userService.insertUser(user);
		
		return"redirect:/shopper/home";
	}
}
