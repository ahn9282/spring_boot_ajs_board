<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시판</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous">
    </script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<style>
	td,th{
	border:1px solid #aaaaaa;
	width:100px;
	text-align:center;
	}
	</style>
	
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>글 제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회 수</th>
			
		</tr>
		<% int l = 1; %>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td><%=l %></td>
				<td><c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
				<a href="${pageContext.request.contextPath }/board/view?bid=${board.bid}">${board.btitle}</a></td>
				<td>${board.bname}</td>
				<td>${board.bdate}</td>
				<td>${board.bhit}</td>
				<td>
				<a href="${pageContext.request.contextPath }/board/delete?bid=${board.bid}" class="btn "type="submit">삭제</a>
				</td>
			</tr>
			<%l++; %>
		</c:forEach>
	</table>
	<form action="${pageContext.request.contextPath }/board/register"method="get">
	
	<button type="submit" class="btn btn-primary">추가 등록</button>
	</form>
</body>
</html>