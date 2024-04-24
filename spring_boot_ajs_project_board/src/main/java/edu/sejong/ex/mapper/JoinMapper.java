package edu.sejong.ex.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.sejong.ex.vo.EmpSalVO;
import edu.sejong.ex.vo.EmpVO;


@Mapper
public interface JoinMapper {
	
	public List<EmpVO> selectJoinList();
	public List<EmpSalVO> selectSalList();
	@Select("select * from emp where ename = #{ename}")
	public EmpVO getEmpVO(String ename);
}
