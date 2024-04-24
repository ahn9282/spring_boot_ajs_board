<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>메인페이지</h1>
   
   <!-- 로그인이 안된 사람 -->
   <sec:authorize access="isAnonymous()">
      <p><a href="<c:url value="/login" />">로그인</a></p>
   </sec:authorize>
   
   <sec:authorize access="isAuthenticated()">
      <p><sec:authentication property="principal.username"/>님 환영합니다.</p>
      <p>email : <sec:authentication property="principal.email"/></p>
    
       <sec:authorize access="hasRole('ROLE_USER')">
             <p>당신은 일반 유저 입니다.</p>
          </sec:authorize>  
       <sec:authorize access="hasRole('ROLE_ADMIN')">
             <p>당신은 어드민입니다.</p>
          </sec:authorize> 

<P><a href="<c:url value="/loginInfo" />">로그인 정보 확인 방법 3가지</a>
   </sec:authorize>
   
 

   
   
   <h3>
       [<a href="<c:url value="/add/addForm" />">회원가입</a>]
       [<a href="<c:url value="/user/userHome" />">유저 홈</a>]
       [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
   </h3>

</body>
</html>