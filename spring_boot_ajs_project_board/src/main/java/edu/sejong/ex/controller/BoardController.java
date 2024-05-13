package edu.sejong.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sejong.ex.LogTrace.LogTrace;
import edu.sejong.ex.LogTrace.TraceStatus;
import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.PageVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController  {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	LogTrace trace;

	@GetMapping("/list")
	public String boardList(Model model,
			@RequestParam(value = "startNum", required = false)Integer StartNum, 
			@RequestParam(value = "endNum", required = false)Integer endNum) {
		 TraceStatus status = null;
		
	        try {
	            status = trace.begin("OrderService.orderItem()");
	            
	        	if(endNum == null || StartNum == null) {
	    			StartNum = 1;
	    			endNum = 5;
	    		}
	    		
	    		model.addAttribute("boards",boardService.boardListPage(StartNum,endNum));
	    		model.addAttribute("boardsLength",boardService.boardList().size());
	    		
	    		trace.end(status);
	    		
	    		return"/board/list";
	    		
	        } catch (Exception e) {
	            trace.exception(status, e);
	            throw e;
	        }
	}
	@GetMapping("/list2")
	public String boardList2(Criteria criteria,Model model) {
		log.info("boardLsit2()..");
	
		
		model.addAttribute("boards",boardService.getListWithPaging(criteria));
		int total = boardService.getTotal();
		model.addAttribute("pageMaker",new PageVO(criteria, total));
		
		
		return"/board/list2";
	}
	
//	@PostMapping("/list")
//	public String boardListPage(Model model,@RequestParam(value = "StartNum", required = false)int StartNum, @RequestParam(value = "endNum", required = false)int endNum) {
//		model.addAttribute("boards",boardService.boardListPage(StartNum,endNum));
//		model.addAttribute("boardsLength",boardService.boardList().size());
//		return"/board/list";
//	}
	
	@GetMapping("/register")
	public String boardRegisterView() {
		 TraceStatus status = null;
			
	        try {
	            status = trace.begin("OrderService.orderItem()");
	    		trace.end(status);
	    		
	    		return"/board/register";	    		
	        } catch (Exception e) {
	            trace.exception(status, e);
	            throw e;
	        }

	}
	
	@PostMapping("/register")
	public String boardRegister(BoardVO board,Model model) {

		
		
		 TraceStatus status = null;
			
	        try {
	            status = trace.begin("OrderService.orderItem()");
	            boardService.registerBoard(board);
	    		trace.end(status);
	    		
	    		return"redirect:/board/list";
	    		} catch (Exception e) {
	            trace.exception(status, e);
	            throw e;
	        }
	}
	
	@GetMapping("/delete")
	public String deleteBoad(BoardVO board,Model model) {
		
		
		
		 TraceStatus status = null;
			
	        try {
	            status = trace.begin("OrderService.orderItem()");
	    		boardService.deleteBoard(board);
	    		trace.end(status);
	    		
	    		return"redirect:/board/list";
	    		} catch (Exception e) {
	            trace.exception(status, e);
	            throw e;
	        }
		}
	
	@GetMapping("/view")
	public String viewBoad(BoardVO board,Model model) {
		
		
		
		 TraceStatus status = null;
			
	        try {
	            status = trace.begin("OrderService.orderItem()");
	            model.addAttribute("board",boardService.viewBoard(board));
	    		trace.end(status);
	    		
	    		return"/board/view";
	    		} catch (Exception e) {
	            trace.exception(status, e);
	            throw e;
	        }
		}
	@PostMapping("/modify")
	public String modifyBoad(BoardVO board,Model model) {
		
		
		
		 TraceStatus status = null;
			
	        try {
	            status = trace.begin("OrderService.orderItem()");
	            boardService.modifyBoard(board);
	    		trace.end(status);
	    		
	    		return"redirect:/board/list";
	    		} catch (Exception e) {
	            trace.exception(status, e);
	            throw e;
	        }
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
