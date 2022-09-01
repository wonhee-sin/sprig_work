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
		let form = document.regForm
		
		if(form.userid.value == ""){
			alert("아이디를 입력해주세요");
			form.userid.focus();
			return false;
		}
		
		if(form.userpw.value == "") {
			alert("비밀번호를 입력해주세요");
			form.userpw.focus();
			return false;
		}
		if(form.username.value == "") {
			alert("이름을 입력해주세요");
			form.username.focus();
			return false;
		}
		if(form.userpw.value != form.userpw_cnf.value) {
			alert("비밀번호가 일치하지 않습니다.");
			form.userpw_cnf.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="signup">
			<h2>회원가입</h2>
			<hr>
			<form action="/member/signup" method="post" name="regForm" onsubmit="return checkForm()">
				<table class="tbl_reg">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid" placeholder="ID"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="userpw" placeholder="PASSWORD"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="userpw_cnf" placeholder="PASSWORD_CONFIRM"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="username" placeholder="NAME"></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" value="등록">
						<input type="reset" value="취소">
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</section>
	</div>
</body>
</html>