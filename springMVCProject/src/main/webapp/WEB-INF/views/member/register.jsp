<%@page import="kr.co.mlec.member.vo.MemberVO"%>
<%@page import="kr.co.mlec.member.dao.MemberDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String emailId = request.getParameter("emailId");
	String emailDo = request.getParameter("emailDo");
	String telA = request.getParameter("telA");
	String telB = request.getParameter("telB");
	String telC = request.getParameter("telC");
	String post = request.getParameter("post");
	String bAddr = request.getParameter("bAddr");
	String dAddr = request.getParameter("dAddr");
	
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setName(name);
	member.setPassword(password);
	member.setEmailId(emailId);
	member.setEmailDo(emailDo);
	member.setTelA(telA);
	member.setTelB(telB);
	member.setTelC(telC);
	member.setPost(post);
	member.setbAddr(bAddr);
	member.setdAddr(dAddr);
	
	MemberDAO dao = new MemberDAO();
	dao.insertMember(member);
	

%>
<script>
	alert('회원 등록이 완료되었습니다')
	location.href = 'memberList.jsp'
</script>