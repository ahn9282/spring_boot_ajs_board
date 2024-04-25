package edu.sejong.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.sejong.ex.service.BoardService;
import edu.sejong.ex.service.TransectionTestService;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tx/*")
public class TransectionTestAjaxController {

	@Autowired
	private TransectionTestService transectionTestService;
	@Autowired
	private BoardService boardService;

	@GetMapping("/boardlist")
	public List<BoardVO> listBoard(Model model) {
		log.info("boardlist ()..");
		return boardService.boardList();
	}

	@GetMapping("/csrf_ex")
	public ModelAndView listBoard(ModelAndView mv) {
		log.info("start()..");
		mv.setViewName("rest_board");

		return mv;
	}

	@DeleteMapping("/boardlist")
	public ResponseEntity<String> TransectionAjaxDeleteBoard(BoardVO board) {
		ResponseEntity<String> entity = null;

		log.info("boardlist()..");
		if(board.getBid() == 0) {
			
			log.info("bid is NULL..");
		}
		try {
			transectionTestService.transectionAjaxDeleteTest1(board);
		} catch (Exception e) {
		}
		return entity;
	}

}
