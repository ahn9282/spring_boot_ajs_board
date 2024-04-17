package edu.sejong.ex.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinVO {
	private DeptVO deptVO = new DeptVO();
	private EmpVO empVO =new EmpVO();
	
	
}
