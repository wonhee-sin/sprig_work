<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href="/resources/CSS/style.css">
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="list">
			<h2>글 목록</h2>
			<h3>
				<security:authentication property="principal.username"/> 님 환영합니다...&nbsp;&nbsp;&nbsp;
			</h3>
			<table class="tbl_list">
				<tr>
					<th>번호</th>
					<th width="50%">제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="board" items="${ boardList }">
				<tr>
					<td>${ board.bno }</td>
					<td><a href="/board/boardView?bno=${ board.bno }">${ board.title }</a></td>
					<td>${ board.writer }</td>
					<td><fmt:formatDate value="${ board.regDate }" pattern="yyyy-MM-dd" /></td>
					<td>${ board.cnt }</td>
				</tr>
				</c:forEach>
			</table>
			<div class="btn_box">
				<a href="./insertBoard"><input type="button" value="글쓰기"></a>
			</div>
		</section>
	</div>
</body>
</html>