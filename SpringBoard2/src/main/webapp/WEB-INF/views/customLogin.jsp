<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title"/></title>
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
	<jsp:include page="./menu.jsp" />
	<div id="container">
		<section id="login">
			<h2><spring:message code="message.user.login.title" /></h2>
<%-- 			<c:if test="${ error==1 }">
				<p class="error"><c:out value="아이디나 비밀번호를 확인해주세요." /></p>
			</c:if> --%>
			<p>
				<a style="color:gold" href="customLogin?lang=en">
					<spring:message code="message.user.login.language.en" />
				</a>
				<a style="color:gold" href="customLogin?lang=ko">
					<spring:message code="message.user.login.language.ko" />
				</a>
			</p>
			<h2><c:out value="${ error }" /></h2>
			<h2><c:out value="${ logout }" /></h2>
			<hr>
			<form action="/login" method="post" name="login" onsubmit="return checkForm()">
				<table class="tbl_login">
					<tr>
						<td><spring:message code="message.user.login.id" /></td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td><spring:message code="message.user.login.password" /></td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="2">
						<button type="submit"><spring:message code="message.user.login.loginBtn"/></button>
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</section>
	</div>
</body>
</html>