<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method = "post">
	글 제목 : <input type="text" name="btitle"><br>
	작성자 : <input type="text" name="bname"><br>
	글 내용 : <textarea name="bcontent"></textarea><br>
	

	<br>
	<button type="submit">입력</button>
	<input type="reset" value="리셋">
	
	</form>
</body>
</html>