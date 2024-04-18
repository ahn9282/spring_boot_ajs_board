package edu.sejong.ex.mapper;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.vo.BoardVO;
@SpringBootTest
class BoardMapperTest {
@Autowired
BoardMapper boardMapper;

	@Disabled
	@Test
	void test() {
		List<BoardVO> list = boardMapper.boardList();
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	@Test
	void addTest() {
		BoardVO board = new BoardVO();
		board.setBname("23");
		board.setBtitle("title");
		board.setBcontent("내용");
		boardMapper.addBoard(board);
	}
	
	@Test
	@DisplayName("마이바티스 3번 째 방법 테스트")
	void test3Usage(){
		List<BoardVO> list = boardMapper.boardList2();
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
}
