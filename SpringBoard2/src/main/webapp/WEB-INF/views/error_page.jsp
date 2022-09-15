<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exception Handling</title>
<link rel="stylesheet" href="/resources/CSS/style.css">
</head>
<body>
	<jsp:include page="./menu.jsp" />
	<div id="container">
		<h3><c:out value="${ exception.getMessage() }" /></h3>
	</div>
</body>
</html>