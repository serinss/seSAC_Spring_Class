<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  ${ myname }!
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<!-- login창 열기 -> 해당 링크만 제대로 잡아주면 됨-->
	<a href="test/login">로그인1(상대경로 이용)</a><br> <!-- 상대 경로 -->
	<a href="/education/test/login">로그인2(절대경로 이용)</a><br> <!-- 절대 경로 -->
	<form action="test/login">
		<input type="submit" value="로그인3(폼 이용 GET)"><br>
	</form>
	
	<form action="test/login" method="post">
		<input type="text" name="userid" value="sesac"><br>
		<input type="password" name="userpwd" value="1234"><br>
		<input type="submit" value="로그인5(폼 이용 POST)"><br>
	</form>
	
	<button id="btn1">로그인4(JS)</button><br>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- onclick(인라인) : JS와 HTML이 섞이면 유지보수에 절대 좋지 않다 -> 고전적 방법 사용 -->
	<script>
	//고전적 방법
	$(function(){
		$('#btn1').click(function(){
			//BOM(Browser Object Model): window, document, loaction, history, screen
			location.href="test/login";
		});
	});
	</script>
	
	
	<!-- HelloController에 params관련 속성 설정함 -->
	<form action="test/helloParam.do">
		<input type="text" name="userid" value="serin"><br>
		<input type="password" name="userpwd" value="1234"><br>
		<!-- <input type="text" name="email" value="serin@naver.com"><br> 
			이메일이 존재하면 이동되지 않음 !email-->
		<input type="submit" value="로그인6(params 설정)"><br>
	</form>



</body>
</html>
