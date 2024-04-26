<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                
                <meta name="_csrf" content="${_csrf.token}" />
                <meta name="_csrf_header" content="${_csrf.headerName}" />
                <!--  -->
                
                <title>게시판</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
                    crossorigin="anonymous" />
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                    crossorigin="anonymous">

                    </script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                
            </head>

            <body>
                <div class="container" id="container">
                </div>
                <script type="text/javascript">
                    $(document).ready(function () {
                        function boardList() {
                            $.ajax({
                                type: "GET",
                                url: "${pageContext.request.contextPath}/tx/boardlist",
                                success: function (result) {
                                    let list = result;

                                    console.log(list);
                                    let container = $("#container");
                                    container.children().remove();
                                    $('<table bordered="1" >').appendTo(container);
                                    let table = $("table");
                                    let tr1 = $('<tr>').appendTo(table);

                                    $('<th>번호</th>').appendTo(tr1);
                                    $('<th>이름</th>').appendTo(tr1);
                                    $('<th>제목</th>').appendTo(tr1);
                                    $('<th>날짜</th>').appendTo(tr1);
                                    $('<th>조회 수</th>').appendTo(tr1);
                                    $('<th>삭제</th>').appendTo(tr1);
                                    $('</tr>').appendTo(table);
                                    let listArea = $('#boardList');
                                    $.each(list, function (index, item) {
                                        let tr2 = $('<tr>').appendTo(table);
                                        $('<td>').appendTo(tr2).text(item.bid);
                                        $('<td>').appendTo(tr2).text(item.bname);

                                        $('<td>').appendTo(tr2).text(item.btitle);
                                        $('<td>').appendTo(tr2).text(item.bdate);
                                        $('<td>').appendTo(tr2).text(item.bhit);
                                        let td = $('<td>').appendTo(tr2);
                                        let bt = $('<button class="btn btn-danger">').appendTo(td).text('삭제').on('click', function () {
                                            console.log(item.bid + "삭제 눌림");
                                            deleteBoard(item.bid);
                                        })
                                        $('</tr>').appendTo(table);
                                    });

                                },
                                error: function (e) {
                                    console.log(e);
                                }
                            });

                        }

                        function deleteBoard(id) {
                            console.log('삭제 버튼 눌림');
                            const token = $("meta[name='_csrf']").attr("content")
                            const header = $("meta[name='_csrf_header']").attr("content");
                            const name = $("#userName").val();

                            $.ajax({

                                type: "delete",
                                url: "${pageContext.request.contextPath}/tx/boardlist",
                                data: { "bid": id },
                                beforeSend: function (xhr) {
                                    xhr.setRequestHeader(header, token);
                                    //ajax호출 중 처리
                                    //글로벌 변수로 설정한 csrf token 셋팅
                                },
                                async: true,
                                success: function (result) {
                                    console.log('Success Delete!' + result);
                                    boardList();

                                },
                                error: function (e) {
                                    console.log(e);
                                }
                            })
                        }
                        boardList();
                    });
                </script>
            </body>

            </html>