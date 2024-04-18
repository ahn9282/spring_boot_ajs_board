package edu.sejong.ex.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.EmpVO;


@Mapper
public interface CompanyMapper {
	
	List<DeptEmpVO> getDeptEmpList();
	
}
