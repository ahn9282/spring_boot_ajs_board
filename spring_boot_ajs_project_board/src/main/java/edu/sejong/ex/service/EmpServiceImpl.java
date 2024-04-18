package edu.sejong.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sejong.ex.mapper.BoardMapper;
import edu.sejong.ex.mapper.JoinMapper;
import edu.sejong.ex.page.Criteria;
import edu.sejong.ex.vo.BoardVO;
import edu.sejong.ex.vo.EmpSalVO;
import edu.sejong.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	JoinMapper joinMapper;

	@Override
	public List<EmpVO> empList() {
		return joinMapper.selectJoinList();
	}

	@Override
	public List<EmpSalVO> empSalList() {
		// TODO Auto-generated method stub
		return joinMapper.selectSalList();
	}
	

}
