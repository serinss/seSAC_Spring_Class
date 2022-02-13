<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<style type="text/css">
	hr, table{
		width: 50%
	}
</style>
<script src="/Mission-Web/js/myJS.js"></script>
<script type="text/javascript">
	/*function isNull(obj, msg){
		if(obj.value == ''){
			alert(msg)
			obj.focus()
			return true
			//여기는 isNull에 대한 리턴값임을 주의
		}
		return false
	}*/
	
	function checkForm(){
		let f = document.loginForm;
		
		if(isNull(f.id, '아이디를 입력하세요'))
			return false
		
		if(isNull(f.password,'패스워드를 입력하세요'))
			return false
		
		return true
		
	}
		//항상 반복되는 함수 형태 -> 공통의 함수를 만들자! -> isNull()
		/*if(f.id.value == ''){
			alert('아이디를 입력하세요')
			f.id.focus()
			return false
		}*/
	
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>로그인</h2>
			<hr>
			<form name="loginForm" action="login.jsp" method="post" onsubmit="return checkForm()">
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<br>
				<button type="submit">로그인</button>
			</form>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/footer.jsp" %>
	</footer>

</body>
</html>