<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
nav{background :black; height: 50px; position:relative;}
h4{position:absolute; margin:0; top:14.5px; left:calc(50% - 133px);}
a{color: pink; text-decoration: none;}
a:hover{color:white}
a:active{outline: 5px solid skyblue; color: skyblue;}

</style>
</head>
<body>
	<security:authorize access="isAnonymous()">
	<nav>
		<h4>
			<a href="/">홈</a>&nbsp; &nbsp;&nbsp;
			<a href="/customLogin">로그인</a>&nbsp; &nbsp;&nbsp;
			<a href="/member/signup">회원가입</a>&nbsp; &nbsp;&nbsp;
			<a href="/board/boardList">글 목록</a>
		</h4>
	</nav>
	</security:authorize>
	
	<security:authorize access="isAuthenticated()">
	<nav>
		<h4>
			<a href="/">홈</a>&nbsp; &nbsp;&nbsp;
			<a href="/customLogout" onclick="return confirm('로그아웃 하시겠습니까?')">로그아웃</a>&nbsp; &nbsp;&nbsp;
			<a href="/member/signup">회원가입</a>&nbsp; &nbsp;&nbsp;
			<a href="/board/boardList">글 목록</a>
		</h4>
	</nav>
	</security:authorize>
</body>
</html>