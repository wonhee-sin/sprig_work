<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<link rel="stylesheet" href="/resources/CSS/style.css">
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="list">
			<h2>글 상세 보기</h2>
			<hr>
			<form action="/board/updateBoard" method="post">
			<input type="hidden" name="bno" value="${ board.bno }">
				<table class="tbl_view">
					<tr>
						<td width="100">제목</td>
						<td align="left"><input type="text" name="title" value="${ board.title }"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td align="left"><input type="text" name="writer" value="${ board.writer }"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td align="left"><textarea name="content" cols="50" rows="10">${ board.content }</textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<security:authentication property="principal" var="pinfo"/>
						<security:authorize access="isAuthenticated()">
						<c:if test="${ pinfo.username eq board.writer }">
							<input type="submit" value="글 수정">
							<a href="/board/deleteBoard?bno=${ board.bno }"
							   onclick="return confirm('정말로 삭제하시겠습니까?')">
							   <input type="button" value="삭제"></a>
						</c:if>
						</security:authorize>
							<a href="/board/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>