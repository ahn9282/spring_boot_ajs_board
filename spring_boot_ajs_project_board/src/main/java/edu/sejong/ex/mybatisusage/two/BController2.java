package edu.sejong.ex.mybatisusage.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.PageVO;

/*
마이바티스 2번째 사용 방법
1.interface 필요없음
2.sqlSession에서 제공하는 함수 selectLsit()를 이용.
3. 쿼리 구현을 위한 XML이 필요.
해당 xml의 namespace는 개발자가 정할 수 있다.
* */

@Controller
@RequestMapping("/two")
public class BController2 {
	
	@Autowired
	private BService2 bService2;
	@Autowired
	private BoardService boardService;

	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		System.out.println("list2()..");
		model.addAttribute("boards",bService2.selectBoardList());
		return "/board/list";
	}
	@GetMapping("/list2")
	public String boardList2(Criteria criteria,Model model) throws Exception {
		System.out.println("boardLsit2()..");
	
		
		model.addAttribute("boards",bService2.selectBoardPagingList(criteria));
		int total = bService2.selectTotal();
		model.addAttribute("pageMaker",new PageVO(criteria, total));
		
		
		return"/board/list2";
	}
	
}
