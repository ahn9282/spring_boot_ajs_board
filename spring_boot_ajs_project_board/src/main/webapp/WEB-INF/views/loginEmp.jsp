<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 정보</title>



</head>
<body>
	<h1>정보 페이지</h1>
<p>principal: <sec:authentication property="principal"/></p>
<p>username: <sec:authentication property="principal.username"/></p>
<p>password: <sec:authentication property="principal.password"/></p>
<p>deptno: <sec:authentication property="principal.emp.deptno"/></p>
<p>sal: <sec:authentication property="principal.emp.sal"/></p>
<p>mgr: <sec:authentication property="principal.emp.mgr"/></p>
<p>job: <sec:authentication property="principal.emp.job"/></p>



</body>
</html>