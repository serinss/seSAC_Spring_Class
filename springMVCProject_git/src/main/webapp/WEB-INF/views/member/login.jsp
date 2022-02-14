<%@page import="kr.co.sesac.model.LoginDAO"%>
<%@page import="kr.co.sesac.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//입력된 아이디, 패스워드 추출
	//회원 테이블에서 해당 아이디, 패스워드가 있는지 확인
	// -> 없으면 다시 로그인
	// -> 있으면 홈페이지로 이동
	
	//post방식은 꼭 인코딩!
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//객체 초기화
	LoginVO loginVO = new LoginVO();
	loginVO.setId(id);
	loginVO.setPassword(password);
	
	//DB에서 사용자 조회
	LoginDAO dao = new LoginDAO();
	
	/*
		반환값이  null : 로그인 실패
		반환값이 !null : 로그인 성공
	*/
	LoginVO userVO = dao.login(loginVO);
	
	String msg = "";
	String url = "";
	if(userVO == null){
		msg = "아이디 또는 패스워드를 잘못입력하셨습니다";
		url = "loginForm.jsp";
	}else{
		switch(userVO.getType()){
			case "S":
				msg = "관리자님 환영합니다";
				break;
			case "U":
				msg = userVO.getId() + "님 환영합니다";
				//memberVO를 사용하는 경우 getName()으로 사용자의 이름을 가져오기
				break;
		}
		url = "/Mission-Web";
		
		//세션 등록 -> 어느 페이지에서나 userVO 로그인 정보에 접근할 수 있음!
		session.setAttribute("userVO", userVO);
	}
	
	pageContext.setAttribute("msg", msg);
	pageContext.setAttribute("url", url);
	
	
%>
<script>
	alert('${ msg }')
	location.href = '${ url }'
</script>