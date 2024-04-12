package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> boards = boardMapper.boardList();
		return boards;
	}

	@Override
	public void registerBoard(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.addBoard(board);
		
	}

	@Override
	public void deleteBoard(BoardVO board) {
	boardMapper.deleteBoard(board);
		
	}

	@Override
	public BoardVO viewBoard(BoardVO board) {
		BoardVO boardNow = boardMapper.viewBoard(board);
		boardMapper.upHit(board);
		return boardNow;
	}

	@Override
	public void modifyBoard(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.modifyBoard(board);
	}

	@Override
	public void replyBoard(BoardVO board) {

boardMapper.replyBoard(board);
boardMapper.replySort(board);
		
	}

}
