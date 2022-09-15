<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery 예제</title>
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("button").click(function(){
			$("h1").css("color", "blue");
			$("#msg").text("고맙습니다.");
		})
	});
</script>
</head>
<body>
	<h1>jQuery</h1>
	
	<button type="button">send</button>
	<div id="msg"></div>
</body>
</html>