package edu.sejong.ex.item;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@MapperScan
@RequestMapping("/test/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	
	@GetMapping("/add")
	public String addItem(Model model) {
		
		itemService.addItem();
		model.addAttribute("items",itemService.select());
		
		return "itemTable";
	}

}
