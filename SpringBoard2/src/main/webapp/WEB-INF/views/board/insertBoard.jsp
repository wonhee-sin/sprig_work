<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<link rel="stylesheet" href="/resources/CSS/style.css">
<script>
	function checkForm(){
		let form = document.write
		
		if(form.title.value == ""){
			alert("제목을 입력해주세요");
			form.title.focus();
			return false;
		}
		
		if(form.writer.value == "") {
			alert("작성자를 입력해주세요");
			form.writer.focus();
			return false;
		}
		
		if(form.content.value == "") {
			alert("내용을 입력해주세요");
			form.content.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="register">
			<h2>글 쓰기</h2>
			<hr>
			<form action="/board/insertBoard" method="post" name="write" onsubmit="return checkForm()"
					encType="multipart/form-data">
				<table class="tbl_reg">
					<tr>
						<td width="100">제목</td>
						<td align="left"><input type="text" name="title"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td align="left"><input type="text" name="writer"
							value='<security:authentication property="principal.username"/>' readonly="readonly"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td align="left"><textarea name="content" cols="50" rows="10"></textarea></td>
					</tr>
					<tr>
						<td>업로드</td>
						<td align="left"><input type="file" name="uploadFile"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="등록">
							<a href="/board/boardList"><input type="button" value="목록"></a>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</section>
	</div>
</body>
</html>