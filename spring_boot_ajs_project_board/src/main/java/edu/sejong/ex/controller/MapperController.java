package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.EmpService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/mapper")
public class MapperController  {
	
	@Autowired
	EmpService empService;

	@GetMapping("/empList")
	public String empJoinList(Model model) {
		model.addAttribute("emps",empService.empList());
		return "mapper/list";
	}
	@GetMapping("/salList")
	public String empJoinSalList(Model model) {
		model.addAttribute("emps",empService.empSalList());
		return "mapper/listSal";
	}

} 
