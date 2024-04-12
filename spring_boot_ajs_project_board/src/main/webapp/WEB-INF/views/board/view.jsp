<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<form action="${pageContext.request.contextPath }/board/modify" method = "post">
	<input type="hidden" name="bid" value="${board.bid}">
	글 제목 : <input type="text" name="btitle" value="${board.btitle}" ><br>
	작성자 : <input type="text" name="bname" value="${board.btitle}" ><br>
	글 내용 : <textarea name="bcontent" > ${board.btitle}</textarea><br>
	 <p>조회수 :  ${board.bhit}</p>

	<br>
	<button type="submit">수정</button>
	<input type="reset" value="리셋">
	<a href="${pageContext.request.contextPath }/board/list" class="btn btn-primary">취소</a>
	</form>
	<form action="${pageContext.request.contextPath }/board/reply_register" method="post">
	<input type="hidden" name="bgroup" value="${board.bgroup }">
	<input type="hidden" name="bstep" value="${board.bstep +1}">
	<input type="hidden" name="bindent" value="${board.bindent +1}">
	비그룹 : ${board.bgroup }
	비 스텝 : ${board.bstep }
	비 인덴트 : ${board.bindent }
	<button type="submit" >댓글달기</button>
	</form>
	
</body>
</html>