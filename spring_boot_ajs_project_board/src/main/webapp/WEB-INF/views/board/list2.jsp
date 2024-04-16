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
	align-items: center;
}

#card-content {
	display: flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
	align-items: center;
}

#card-content>table {
	width: 100%;
	margin-bottom: 3%;
}

/* #page a {
	border: 1px solid #aaaaaa;
	width: 3em;
	height: 3em;
	margin: 0;
	text-decoration: none;
	display: flex;
	justify-content: center;
	text-align: center;
	align-items: center;
}

#page-a1 {
	border-radius: 10px 0 0 10px;
}

#page-a2 {
	border-radius: 0 10px 10px 0;
} */
</style>

</head>
<body>
	<div class="container ">
		<div class="card">

			<div class="card-header text-center" id="card-content">
				<h2>게시판</h2>
			</div>
			<div class="card-body" id="card-content">

				<table border="1">
					<tr>
						<th>번호</th>
						<th>글 제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회 수</th>
					</tr>
					<c:forEach var="board" items="${boards}">
						<tr>
							<td>${board.rnum}</td>
							<td><c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
								<a
								href="${pageContext.request.contextPath }/board/view?bid=${board.bid}">${board.btitle}</a></td>
							<td>${board.bname}</td>
							<td style="min-width: 200px;">${board.bdate}</td>
							<td>${board.bhit}</td>
							<td><a
								href="${pageContext.request.contextPath }/board/delete?bid=${board.bid}"
								class="btn btn-primary" type="submit">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
				<div id="page"
					class="d-flex flex-row justify-content-center align-items-center">
					<nav aria-label="Search results pages">
						<ul class="pagination">

							<c:if test="${pageMaker.prev}">
								<li class="page-item" ><a id="page-a1" class="page-link"
									href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">
										<< </a></li>
							</c:if>

							<c:forEach var="idx" begin="${pageMaker.startPage}"
								end="${pageMaker.endPage}">
								<c:if test="${idx == pageMaker.criteria.pageNum }">
								<li class="page-item active" >
								</c:if>
								<c:if test="${idx != pageMaker.criteria.pageNum }">
								<li class="page-item" >
								</c:if>
								<a class="page-link"
									href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
									</li>
							</c:forEach>


							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li class="page-item"><a class="page-link" id="page-a2"
									href="list2${pageMaker.makeQuery(pageMaker.endPage + 1) }">
										>> </a></li>
							</c:if>

						</ul>
					</nav>
				</div>

			</div>
			<div class="card=footer w-100 m-3" id="card-content"
				style="border-top: 1px solid #aaaaaa;">
				<form action="${pageContext.request.contextPath }/board/register"
					method="get">

					<button type="submit" class="btn btn-primary mt-3">추가 등록</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>