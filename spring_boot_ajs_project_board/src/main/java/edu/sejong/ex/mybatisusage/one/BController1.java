package edu.sejong.ex.mybatisusage.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
마이바티스 1번째 사용 방법
1.interface IBDao를  XML namespac에 매핑 <mapper namespace="패키지명.IBDao"> 
2.sqlSession.getMapper(IBDao.class)를 이용.
* */

@Controller
@RequestMapping("/one")
public class BController1 {
	
	@Autowired
	private BService1 bService1;
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		System.out.println("list()..");
		model.addAttribute("boards",bService1.selectBoardList());
		return "/board/list";
	}
}
