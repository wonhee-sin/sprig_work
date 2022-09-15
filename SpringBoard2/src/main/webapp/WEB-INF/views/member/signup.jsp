<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome~</title>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/resources/CSS/style.css?13253">

<script>

	function checkForm(){
		let id = document.getElementById("userid");
		let pwd1 = document.getElementById("userpw");
		let pwd2 = document.getElementById("userpw_cnf");
		let name = document.getElementById("username");
		let idChkVal = document.getElementById("idCheck");
		
		let regExpId = /^[a-zA-Z0-9]*$/
		let regExpPwd1 = /[a-zA-Z0-9]/
		let regExpPwd2 = /[~!@#$%^&*()_+/]/
		let regExpPwd3 = /^[ㄱ-ㅎㅏ-ㅣ가-힣]*$/
		
		if(id.value.length < 4 || id.value.length > 12 || !regExpId.test(id.value)){
			alert("아이디를 입력해주세요");
			return false;
		}
		
		if(!regExpPwd1.test(pwd1.value) || !regExpPwd2.test(pwd1.value)) {
			alert("비밀번호를 입력해주세요");
			return false;
		}
		if(pwd1.value != pwd2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		if(name.value == "") {
			alert("이름을 입력해주세요");
			return false;
		}

		if(idChkVal.value == "N"){
			alert("아이디 중복 확인을 해주세요");
			return false;
		}
	}
	
	function checkID(){
		$.ajax({
			type: "get",
			url : "http://localhost:8080/member/checkID",
			dataType: "json",
			data: {"userid": $("#userid").val()},
			success: function(data){
				if(data == 1){
					$("#check").text("이미 가입된 ID입니다.");
					$("#check").css({"color": "red", "padding-top": "5px"});
				}else if(data == 0){
					$("#idCheck").attr("value","Y");
					$("#check").text("사용 가능한 ID입니다.");
					$("#check").css({"padding-top": "5px"});
				}
			},
			error: function(data){
				alert("error");
			}
		});
	}

</script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="signup">
			<h2>회원가입</h2>
			<hr>
			<form action="/member/signup" method="post" id="regForm" name="regForm" 
				  onsubmit="return checkForm()">
				<table class="tbl_reg">
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" id="userid" name="userid" placeholder="ID">
							<button type="button" id="idCheck" value="N" onclick="checkID()">ID 중복</button>
							<p id="check"></p>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" id="userpw" name="userpw" placeholder="PASSWORD"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" id="userpw_cnf" name="userpw_cnf" placeholder="PASSWORD_CONFIRM"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" id="username" name="username" placeholder="NAME"></td>
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