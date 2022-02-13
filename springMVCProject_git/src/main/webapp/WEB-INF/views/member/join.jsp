
<%@page import="kr.co.sesac.vo.MemberVO"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 인코딩(Port)
	request.setCharacterEncoding("utf-8");
	
	//2. 입력한 값을 getParameter 로 추출하기
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String emailId = request.getParameter("email_id");
	String emailDomain = request.getParameter("email_domain");
	String telA = request.getParameter("tel1");
	String telB = request.getParameter("tel2");
	String telC = request.getParameter("tel3");
	String post = request.getParameter("post");
	String basicAddr = request.getParameter("basic_addr");
	String detailAddr = request.getParameter("detail_addr");
	
	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPassword(password);
	member.setName(name);
	member.setEmailId(emailId);
	member.setEmailDo(emailDomain);
	member.setTelA(telA);
	member.setTelB(telB);
	member.setTelC(telC);
	member.setPost(post);
	member.setBasicAddr(basicAddr);
	member.setDetailAddr(detailAddr);
	
	MemberDAO dao = new MemberDAO();
	dao.insertMember(member);
	
	
	
	//3. tbl_member 에 insert
	/*Connection conn = new ConnectionFactory().getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append("insert into tbl_member(id, name, password, email_id, email_domain, tel1, tel2, tel3, post, basic_addr, detail_addr) ");
	sql.append(" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	pstmt.setString(3, name);
	pstmt.setString(4, email_id);
	pstmt.setString(5, email_domain);
	pstmt.setString(6, tel1);
	pstmt.setString(7, tel2);
	pstmt.setString(8, tel3);
	pstmt.setString(9, post);
	pstmt.setString(10, basic_addr);
	pstmt.setString(11, detail_addr);
	
	pstmt.executeUpdate();*/
	
	
	
%>
<script>
	alert('회원 가입이 완료되었습니다!')
	location.href = 'list.jsp'
</script>