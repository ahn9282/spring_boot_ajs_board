package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> boardListPage(int startNum, int endNum);
	List<BoardVO> boardList();
	void addBoard(BoardVO board);
	void deleteBoard(BoardVO board);
	BoardVO viewBoard(BoardVO board);
	void modifyBoard(BoardVO board);
	void upHit(BoardVO board);
	void replyBoard(BoardVO board);
	void replySort(BoardVO board);
	
}
