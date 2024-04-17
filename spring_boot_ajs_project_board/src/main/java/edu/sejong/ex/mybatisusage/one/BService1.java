package edu.sejong.ex.mybatisusage.one;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.vo.BoardVO;

@Service
public class BService1 {

	
	@Autowired
	private SqlSessionTemplate SqlSession;
	//private SqlSession SqlSession;
	
	public List<BoardVO> selectBoardList() throws Exception{
		
		IBDao dao = SqlSession.getMapper(IBDao.class);
		
		return dao.listDao();
	}
}
