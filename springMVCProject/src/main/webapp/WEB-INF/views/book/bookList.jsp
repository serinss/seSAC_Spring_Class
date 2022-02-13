<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 table, tr{
 	border-collaps: collapse;
 }
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$(".delBtn").click(function(){
			var bno = $(this).attr("data-bno");
			if(confirm("삭제하시겠습니까?")){
				location.href="delete?bno=" + bno;
			}
		});
	});
</script>
</head>
<body>

<p>${ msg }</p>
<!-- 현재 페이지는 도서 관련해서만 경로를 설정하므로 http://localhost:9999/education/book 을 등록해두기 -->
<c:set var="path" value="${ pageContext.request.contextPath }/book"></c:set>

<!-- 상대 경로 : insert
	 절대 경로 : ${ path }/insert -->
<a href="${ path }/insert">신규 도서 등록</a><br><br>
<h1>도서 목록</h1>
<table border="1">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>저자</td>
		<td>출판사</td>
		<td>출판일</td>
		<td>상태</td>
		<td>삭제하기</td>
	</tr>
	<c:forEach items="${bookList}" var="book">
		<tr>
			<!-- 상대 경로보다 절대 경로를 권장
				 중복되는 경로는 반복적으로 직접 쓰는 것 X (가변적 필요) -> c:set 으로 등록
				 무조건 유지보수하기 편하도록 작성하기 -->
			<td><a href="${ path }/list/detail?bno=${ book.bno }">${ book.bno }</a></td>
			<td>${ book.title }</td>
			<td>${ book.author }</td>
			<td>${ book.pub }</td>
			<td>${ book.pubDate }</td>
			<td>${ book.status }</td>
			<td><button class="delBtn" data-bno="${ book.bno }">삭제</button></td>
			<!-- 삭제할 번호를 버튼에 저장해두어 해당 번호를 삭제할 수 있도록 -->
		</tr>
	</c:forEach>
</table>
</body>
</html>