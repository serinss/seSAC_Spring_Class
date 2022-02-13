<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
	<table border="1">
		<tr>
			<td>번호</td>
			<td><input type="text" name="bno" value="${ book.bno }"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${ book.title }"></td>
		</tr>
		<tr>
			<td>저자</td>
			<td><input type="text" name="author"  value="${ book.author }"></td>
		</tr>
		<tr>
			<td>출판사</td>
			<td><input type="text" name="pub"  value="${ book.pub }"></td>
		</tr>
		<tr>
			<td>출판일</td>
			<td><input type="text" name="pubDate"  value="${ book.pubDate }"></td>
		</tr>
		<tr>
			<td>상태</td>
			<td><input type="text" name="status"  value="${ book.status }"></td>
		</tr>
	</table><br>
	<input type="submit" value="수정하기">
</form>
</body>
</html>