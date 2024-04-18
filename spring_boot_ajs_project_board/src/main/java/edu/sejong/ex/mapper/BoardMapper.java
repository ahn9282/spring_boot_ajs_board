package edu.sejong.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> boardListPage(int startNum, int endNum);

	List<BoardVO> boardList();
	
	@Select(" select * from mvc_board order by bgroup desc, bstep asc")
	List<BoardVO> boardList2();
	
	void addBoard(BoardVO board);
	void deleteBoard(BoardVO board);
	BoardVO viewBoard(BoardVO board);
	void modifyBoard(BoardVO board);
	void upHit(BoardVO board);
	void replyBoard(BoardVO board);
	void replySort(BoardVO board);
	List<BoardVO> getListWithPaging(Criteria cri);
	int getToatalCount();
	
	
}
