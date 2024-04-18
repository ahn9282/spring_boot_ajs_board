package edu.sejong.ex.mybatisusage.two;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;

@Service
public class BService2 {

	@Autowired
	private SqlSessionTemplate SqlSession;//이것이 마이 바티스 객체
	// private SqlSession SqlSession;

	public List<BoardVO> selectBoardList() throws Exception {

		return SqlSession.selectList("board.selectBoardList");
	}
	public List<BoardVO> selectBoardPagingList(Criteria cri) throws Exception {
		
		return SqlSession.selectList("board.selectBoardPagingList",cri);
	}
	public int selectTotal()throws Exception {
		return SqlSession.selectOne("board.selectTotal");
	}
}
