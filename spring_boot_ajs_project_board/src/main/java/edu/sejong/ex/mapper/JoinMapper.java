package edu.sejong.ex.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.EmpSalVO;
import edu.sejong.ex.vo.EmpVO;


@Mapper
public interface JoinMapper {
	
	public List<EmpVO> selectJoinList();
	public List<EmpSalVO> selectSalList();
	
}
