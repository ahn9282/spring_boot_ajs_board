package edu.sejong.ex.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.sejong.ex.service.EmpService;
import edu.sejong.ex.vo.DeptEmpVO;
import edu.sejong.ex.vo.EmpSalVO;
import edu.sejong.ex.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class JoinMapperTest {

	
	@Autowired
	JoinMapper joinMapper;
	@Autowired
	EmpService empService;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@Disabled
	@Test
	void test() {
		log.info("로그가 안찍힘");
		List<EmpVO> list = empService.empList();
		assertNotNull(list);
		
	}

	@Disabled
	@Test
	void testGetDeptEmpList() {
		for(DeptEmpVO vo : companyMapper.getDeptEmpList()) {
			log.info("{}",vo);
			log.info("사원 번호 : {}",vo.getDeptno());
			log.info("부서 명 : {}",vo.getDname());
		}
	}
	
	@Test
	void test2() {
		List<EmpSalVO> list = joinMapper.selectSalList();
		for(EmpSalVO e : list) {
			log.info("부서 번호 = {}",e.getDeptno());
		}
		List<EmpSalVO> list1 = empService.empSalList();
		for(EmpSalVO e : list1) {
			log.info("{}",e);
		}
		
	}
	
}
