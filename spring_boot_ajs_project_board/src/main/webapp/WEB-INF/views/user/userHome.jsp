<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin HOme</title>
</head>
<body>
<h1>사용자 페이지 입니다.</h1>
<p>principal: <sec:authentication property="principal"/></p>
<p>id: <sec:authentication property="principal.username"/>님 환영합니다.</p>
<p>password: <sec:authentication property="principal.password"/></p>

<sec:authorize access="isAnonymous()">
<p><a href="<c:url value="/login" />">로그인</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
<p><sec:authentication property="principal.username"/>님 환영합니다.</p>
</sec:authorize>




 <p>EmpVO: <sec:authentication property="principal.emp"/></p>

<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p> 

<p>CartVO: <sec:authentication property="principal.cart"/></p>

<p>상품: <sec:authentication property="principal.cart.product"/></p>
<p>수량: <sec:authentication property="principal.cart.count"/></p>


<h3>[<a href="<c:url value="/" />">홈</a>]</h3>
</body>
</html>