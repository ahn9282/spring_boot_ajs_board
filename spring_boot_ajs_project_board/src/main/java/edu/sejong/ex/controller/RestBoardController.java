package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.PageVO;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@RestController
@RequestMapping("/boards")
public class RestBoardController {
	
	
	
	@Autowired
	private BoardService boardService;
	
	
	
	@GetMapping("/list")
	public List<BoardVO> listBoard(Model model){
		log.info("list ()..");
		return boardService.boardList();
	}
	
	@GetMapping("/start")
	public ModelAndView listBoard(ModelAndView  mv){
		log.info("start()..");
		mv.setViewName("rest/rest_list");
	
		return mv;
	}
	
	@GetMapping("/list/{bid}")
	public BoardVO rest_ContentBoard(BoardVO boardVO ){
		log.info("rest_ContentBoard ()..");
		return boardService.viewBoard(boardVO);
	}
	
	@GetMapping("/select")
	public ModelAndView getSelectBoard(ModelAndView  mv){
		log.info("getSelectBoard()..");
		mv.setViewName("rest/rest_list");
		return mv;
	}
	
	@DeleteMapping("/list/{bid}")
	public ResponseEntity<String> rest_DeleteBoard(BoardVO board ){
		log.info("rest_ContentBoard ()..");
		ResponseEntity<String> entity = null;
		
		try {
			boardService.deleteBoard(board);
			 entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
			
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@GetMapping("/delete")
	public ModelAndView getDeleteBoard(ModelAndView  mv){
		log.info("getDeleteBoard()..");
		mv.setViewName("rest/rest_list");
		return mv;
	}
	@GetMapping("/list/paging")
	public List<BoardVO> getBoardPaging(Criteria criteria,ModelAndView  mv){
		log.info("getBoardLength()..");
		return boardService.getListWithPaging(criteria);
		
	}
	@GetMapping("/list/page")
	public PageVO getBoardLength(Criteria criteria,ModelAndView  mv){
		log.info("getBoardLength()..");
		
		return new PageVO(criteria,boardService.getTotal());
	}
	
	
	
	@PostMapping("/")
	public ResponseEntity<String> restWrite(@RequestBody BoardVO boardVO){
		ResponseEntity<String> entity = null;
		
		log.info("restwrite()..");
		try {
			boardService.registerBoard(boardVO);
		} catch (Exception e) {
		}
		return entity;
	}
	@PutMapping("/{bid}")
	public ResponseEntity<String> restUpdate(@RequestBody BoardVO boardVO){
		ResponseEntity<String> entity = null;
		
		log.info("restwrite()..");
		try {
			boardService.modifyBoard(boardVO);
		} catch (Exception e) {
		}
		return entity;
	}
}
