<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img {margin-left:30px;}
.header{
	position :absolute;
	width:100%;
	top:0;
	left:0;
	z-index:1000;
}
#login_btn{
	float:right;
	margin-right : 30px;
	margin-top: -2px;
	width: 90px; 
	height: 38px; 
	background: red; 
	border: 0; 
	border-radius: 5px; 
	color: #fff;
}
#lang{
	position:relative;
	float:right;
	margin-right: 100px;
	top:-2px;
}
#lang_sel{
	color: #fff; 
	width: 98px; 
	height: 36px; 
	border: 0;
	appearance: none; 
	box-sizing: border-box;
	text-align: center; 
    background: none; 
}

#login_btn:hover{
	cursor: pointer;
}
#iconposition1{
	color:white;
	position:absolute;
	top:10px;
	left:5px;
}
#iconposition2{
	color:white;
	position:absolute;
	top:10px;
	right:7px;
}

a{
	color : #222;
}

.dropdown {
	width:30px;
	float:right;
	margin-right:30px;
}
.my-info{
	float:right;
	margin-right : 30px;
	cursor: pointer;
}
.dropdown-submenu {
	display : none;
	clear:both;
	width: 150px;
	margin-top : 0;
	background:  rgba(0, 0, 0, 0.7);
	
	box-shadow : 0 0 10px rgba(0, 0, 0, 0.17);
	transform :translateX(-100%);
}
.dropdown-submenu a {
	display : block;
	padding : 7px;
	text-align: center;
	color:#eee;
}
.dropdown-submenu a:hover {
	text-decoration: underline;
}
.dropdown:hover .dropdown-submenu{
	display : block;
}
</style>
</head>
<body>
	<div class="header" style="background: rgba(0, 0, 0, 0.2); height: 50px; padding-top:20px">
		<security:authorize access="isAnonymous()" >
			<a href="/customLogin"><button id="login_btn" type="button">로그인</button></a>
		</security:authorize>
		
 		<security:authentication property="principal" var="pinfo" />
		<security:authorize access="isAuthenticated()" >
			<c:if test="${ pinfo.authorities eq '[MEMBER]'}">
				<div class="dropdown">
					<a class="my-info"><img src="../resources/image/icon.png"></a>
					<div class="dropdown-submenu">
						<a href="/member/memberView?id=<c:out value="${pinfo.username}" />">계정 관리</a>
						<a href="/customLogout">로그 아웃</a>
					</div>
				</div>
			</c:if>
			
 			<c:if test="${ pinfo.authorities eq '[ADMIN]'}">
				<div class="dropdown">
					<a class="my-info"><img src="../resources/image/icon.png"></a>
					<div class="dropdown-submenu">
						<a href="/customLogout">로그 아웃</a>
						<a href="/board/insertBoard">콘텐츠 작성</a>
					</div>
				</div>
			</c:if>
		</security:authorize>
		
		<img width="106rem" alt="넷플릭스 로고" src="../resources/image/Logonetflix.png">
		<div id="lang">
			<i id="iconposition1" class="xi-globus"></i>
			<select id="lang_sel" tabindex="0">	
				<option value="ko" style="background : #919191">한국어</option>
				<option value="eng" style="background : #919191">영어</option>
			</select>
			<i id="iconposition2" class="xi-caret-down-min"></i>
		</div>
	</div>
</body>
</html>