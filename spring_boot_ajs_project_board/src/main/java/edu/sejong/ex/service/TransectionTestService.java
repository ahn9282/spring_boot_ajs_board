package edu.sejong.ex.service;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransectionTestService {
	@Autowired
	private BoardMapper mapper;

	public void transectionTest1() {

		log.info("transectionTest1() 테스트");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");

		mapper.addBoard(boardVO);

		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");

		mapper.addBoard(boardVO2);
	}

	public void transectionTest2() {

		log.info("transectionTest2() 테스트");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션1");
		boardVO.setBname("트랜잭션1");
		boardVO.setBtitle("트랜잭션1");

		mapper.addBoard(boardVO);

		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션2");
		boardVO2.setBname("트랜잭션2");
		boardVO2.setBtitle("트랜잭션2");

		boardVO2 = null;
		mapper.addBoard(boardVO2);
	}

	@Transactional
	public void transectionTest3() {

		log.info("transectionTest3() 테스트");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션3");
		boardVO.setBname("트랜잭션3");
		boardVO.setBtitle("트랜잭션3");

		mapper.addBoard(boardVO);

		BoardVO boardVO2 = new BoardVO();
		boardVO2.setBcontent("트랜잭션3");
		boardVO2.setBname("트랜잭션3");
		boardVO2.setBtitle("트랜잭션3");

		boardVO2 = null;
		mapper.addBoard(boardVO2);
	}

	@Transactional
	public void transectionTest4() {

		log.info("transectionTest4() 테스트");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션4");
		boardVO.setBname("트랜잭션4");
		boardVO.setBtitle("트랜잭션4");

		mapper.addBoard(boardVO);

		throw new RuntimeException("RuntimeException for rollBack");

	}

	// 롤백 X
	@Transactional
	public void transectionTest5() throws SQLException {

		log.info("transectionTest5() 테스트");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션5");
		boardVO.setBname("트랜잭션5");
		boardVO.setBtitle("트랜잭션5");

		mapper.addBoard(boardVO);

		throw new SQLException("RuntimeException for rollBack");

	}
	// @Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함.
	// Exception예외로 롤백을 하려면 다음과 같이 지정하면됩니다. @Transactional(rollbackFor = Exception.class)
	// 여러개의 예외를 지정할 수도 있습니다. @Transactional(rollbackFro = {RuntimeException.class, Exception.class})
	// 모든 Exception발생 시 트랜잭션 rollback수행
	@Transactional(rollbackFor = Exception.class)
	public void transectionTest6() throws SQLException {

		log.info("transectionTest6() 테스트");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션6");
		boardVO.setBname("트랜잭션6");
		boardVO.setBtitle("트랜잭션6");

		mapper.addBoard(boardVO);

		throw new SQLException("RuntimeException for rollBack");

	}
	
	//특정 Exception을 지정하여 rollback처리 설정
	@Transactional(rollbackFor = SQLException.class)
	public void transectionTest7() throws SQLException {
		
		log.info("transectionTest7() 테스트");
		BoardVO boardVO = new BoardVO();
		boardVO.setBcontent("트랜잭션7");
		boardVO.setBname("트랜잭션7");
		boardVO.setBtitle("트랜잭션7");
		
		mapper.addBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollBack");
		
	}

	public void transectionAjaxDeleteTest1(BoardVO board) {
		log.info("transectionAjaxDeleteTest1().. 테스트");

		mapper.deleteBoard(board);

	}

}
