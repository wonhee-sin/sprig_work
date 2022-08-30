<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<link rel="stylesheet" href="/resources/CSS/style.css?13253">
<script>
	function checkForm(){
		let form = document.login
		
		if(form.id.value == ""){
			alert("아이디를 입력해주세요");
			form.id.focus();
			return false;
		}
		
		if(form.passwd.value == "") {
			alert("비밀번호를 입력해주세요");
			form.passwd.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div id="container">
		<section id="login">
			<h2>로그인</h2>
<%-- 			<c:if test="${ error==1 }">
				<p class="error"><c:out value="아이디나 비밀번호를 확인해주세요." /></p>
			</c:if> --%>
			<h2><c:out value="${ error }" /></h2>
			<h2><c:out value="${ logout }" /></h2>
			<hr>
			<form action="/login" method="post" name="login" onsubmit="return checkForm()">
				<table class="tbl_login">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
						<button type="submit">로그인</button>
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</section>
	</div>
</body>
</html>