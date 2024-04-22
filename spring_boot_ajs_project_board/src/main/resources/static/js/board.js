
// boardService().test();
/*const boardService = function() {
	
	return {
		test : function test(){
			console.log('테스트 입니다. ');
		}
	}
	
}*/

console.log("===========");

//boardService.test();
const boardService = (function() {
	
	function getBoard(id) {
		$.ajax({
			type: "GET",
			url: "/boards/list/" + id,
			success: function (result) {
				console.log(result);
			},
			error: function (e) {
				console.log(e);
			}
		});

	}
	
	function deleteBoard(id,pageNum,amount) {
		$.ajax({
			type: "DELETE",
			url: "/boards/list/" + id,
			success: function (result) {
				console.log('Success Delete!' + result);
				
				boardListPaging(pageNum,amount);
			},
			error: function (e) {
				console.log(e);
			}
		});
	}
	
	function boardListPaging(pageNum,amount) {
		$.ajax({
			type: "GET",
			url: "/boards/list/paging",
			data:{'pageNum':pageNum,
				'amount' : amount},
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
					let bt = $('<button class="btn btn-danger">').appendTo(td).text('삭제').on('click',function(){
						console.log(item.bid + "삭제 눌림");
						deleteBoard(item.bid,pageNum,amount);
					})
					$('</tr>').appendTo(table);
				});
				pageBoard(pageNum,amount);
			},
			error: function (e) {
				console.log(e);
			}
		});

	}
	function pageBoard(pageNum,amount) {
		$.ajax({
			type: "get",
			url: "/boards/list/page",
			data:{'pageNum':pageNum,
				'amount' : amount},
			success: function (result) {
				let pageArea = $("#page");
				pageArea.children().remove();
				let pageNum =result.pageNum;
				if (result.prev == true) {
				$("<button >").appendTo(pageArea).text("<<").on("click",function(){
					boardListPaging((result.criteria.pageNum - 11),amount);
				});
				}
			 	for(let i = result.startPage; i <= result.endPage;i++){
					$("<button>").appendTo(pageArea).text(i).on("click",function(){
						boardListPaging(i + 1,amount);
																	
					});
				} 
				if (result.next == true) {
					$("<button >").appendTo(pageArea).text(">>").on("click",function(){
						boardListPaging((result.criteria.pageNum + 11),amount);
					});
				}
			},
			error: function (e) {
				console.log(e);
			}
		})
	};
	
	return {
		test : function test(){
			console.log('테스트 입니다. ');
		},
		pagingList:boardListPaging,
		get:getBoard,
		del:deleteBoard,
		page:pageBoard
	}
	
})();


/*const boardPagingList = (function(){
	
	function boardListPaging(pageNum,amount,callback) {
		$.ajax({
			type: "GET",
			url: "/boards/list/paging",
			data:{'pageNum':pageNum,
				'amount' : amount},
			success: function (result) {
				let list = result;

				console.log(list);
				if(callback){
					callback(result);
				}
				
			},
			error: function (e) {
				console.log(e);
			}
		});

	}
	
	return {
		list:function list(callback){
			callback();
		}
	}
})();*/
