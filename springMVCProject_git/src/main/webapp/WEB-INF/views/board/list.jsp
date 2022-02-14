<%@page import="java.sql.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" >
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" >
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
   
   $(document).ready(function() {
      $('button').click(function() {
         location.href = "${pageContext.request.contextPath}/board/writeForm.do"
      })
   })
   
   function doAction(boardNo){
	   location.href = '${ pageContext.request.contextPath }/board/detail.do?no='+boardNo
       
	   //로그인 기능 없는 상태
      /* <c:choose>
            <c:when test="${ not empty userVO }">
               location.href = '${ pageContext.request.contextPath }/board/detail.do?no='+boardNo
                     
         </c:when>
            <c:otherwise>
               if(confirm('로그인 서비스가 필요합니다\n로그인페이지로 이동하시겠습니까?')){
                  location.href = '${ pageContext.request.contextPath }/login.do'
               }   
            </c:otherwise>
         </c:choose> */
   }
</script>
<style>
	span{ background-color: gray;}
</style>
</head>
<body>
   <header>
     <jsp:include page="../include/topMenu.jsp" />
   </header>
   <section>
      <div align="center">
      <hr>
      <h2>게시판 목록		<span>${ msg }</span></h2>
      <hr>
      <br>
      <span>전체 게시글 수 : ${boardCnt }</span><!-- 안뜸.. 다른 프로젝트 list.jsp 호출되는듯 -->
      <table border = "1" class="list">
         <tr>
            <th width="7%">번호</th>
            <th>제목</th>
            <th width = "16%">글쓴이</th>
            <th width = "10%">조회수</th>
            <th width = "20%">등록일</th>
         </tr>
       
      <c:forEach items="${ list }" var="board">
       <tr>
          <td>${ board.no }</td>
          <td>
             <a href="javascript:doAction(${ board.no })">
                <c:out value="${ board.title }" />
             </a>
             
          </td>
          <td>${ board.writer }</td>
          <td>${ board.viewCnt }</td>
          <td>${ board.regDate }</td>
       </tr>
      </c:forEach>
      </table>
      <br>
      <%-- <c:if test="${ not empty userVO }"> --%>
      	<button>새글등록</button>
      <%-- </c:if> --%>
   </div>   
   </section>    
   <footer>
      <%-- <%@ include file="/jsp/include/footer.jsp" %> --%>
   </footer>   
</body>
</html>

