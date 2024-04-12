package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;



@Controller
@RequestMapping("/board")
public class BoardController  {
	
	@Autowired
	BoardService boardService;

	@RequestMapping("/list")
	public String boardList(Model model) {
		model.addAttribute("boards",boardService.boardList());
		return"/board/list";
	}
	
	@GetMapping("/register")
	public String boardRegisterView() {
		return"/board/register";
	}
	
	@PostMapping("/register")
	public String boardRegister(BoardVO board,Model model) {
		
		boardService.registerBoard(board);
		
		return"redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String deleteBoad(BoardVO board,Model model) {
		
		boardService.deleteBoard(board);
		
		return"redirect:/board/list";
		}
	
	@GetMapping("/view")
	public String viewBoad(BoardVO board,Model model) {
		
		model.addAttribute("board",boardService.viewBoard(board));
		
		return"/board/view";
		}
	@PostMapping("/modify")
	public String modifyBoad(BoardVO board,Model model) {
		
		boardService.modifyBoard(board);
		
		return"redirect:/board/list";
	}
	
	@PostMapping("/reply_register")
	public String replyViewBoad(BoardVO board,Model model) {
		model.addAttribute("board",board);
		
		return"/board/reply_register";
		}
	@PostMapping("/reply")
	public String replyBoad(BoardVO board,Model model) {
		
		boardService.replyBoard(board);
		return"redirect:/board/list";
	}

}
