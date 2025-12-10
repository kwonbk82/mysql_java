<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="com.spring.biz.board.BoardDao"%>
<%@page import="com.spring.biz.board.BoardDto"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 1. 검색할 게시글 번호 추출
	BoardDto board = (BoardDto) session.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>게시판 프로그램</h1>
		<a href="login.do">로그인</a>
		<hr>
			<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteBoard.do?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글목록</a>
		<hr>
		
	</center>

</body>
</html>