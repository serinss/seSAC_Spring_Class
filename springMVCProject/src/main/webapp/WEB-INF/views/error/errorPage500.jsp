<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <!-- 에러페이지 설정 -> 내역을 찍을 수 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오류 정보(연산 오류 페이지)</h1>
<%=exception %><br>
<%=exception.getMessage() %>
</body>
</html>