package edu.sejong.ex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVO;
@Service
public interface BoardService  {

	List<BoardVO> boardList();
	void registerBoard(BoardVO board);
	void deleteBoard(BoardVO board);
	BoardVO viewBoard(BoardVO board);
	void modifyBoard(BoardVO board);
	void replyBoard(BoardVO board);
}
