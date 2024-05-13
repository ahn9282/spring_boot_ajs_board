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
td, th {
	border: 1px solid #aaaaaa;
	width: 100px;
	text-align: center;
}
</style>

</head>
<body>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가격</th>
			<th>수량</th>

		</tr>
	
		<c:forEach var="item" items="${items}">
			<tr>

				<td>${item.id }</td>
				<td>${item.itemName}</td>
				<td>${item.price}</td>
				<td>${item.quantity}</td>
				
			</tr>
		
		</c:forEach>
	</table>
	<form action="" method="get">
	<button type="submit">추가</button></form>
	
		
</body>
</html>