package edu.sejong.ex.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//lombok사용하여 생성자2개, getter, setter, toString메소드 생성
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpVO {
 //변수와 변수 각각의 데이터 타입 표시
 int empno; //NOT NULL NUMBER(4)    
 String ename; //VARCHAR2(10)
 String job; //VARCHAR2(9) 
 int mgr; //NUMBER(4)
 Timestamp hiredate; //DATE
 int sal; //NUMBER(7,2) 
 int comm; //NUMBER(7,2) 
 int deptno; //NUMBER(2)
 private DeptVO deptVO;
}
