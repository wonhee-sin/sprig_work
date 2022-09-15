<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href="/resources/CSS/style.css">
<script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="container">
		<section id="list">
			<h2>글 목록</h2>
			<h3>
				<security:authentication property="principal.username"/> 님 환영합니다...&nbsp;&nbsp;&nbsp;
			</h3>
			<form action="/board/boardList" method="get" id="searchForm">
				<select name="type">
					<option value="T">제목</option>
					<option value="C">내용</option>
					<option value="W">작성자</option>
					<option value="TC">제목 or 내용</option>
					<option value="TW">제목 or 작성자</option>
					<option value="TWC">제목 or 내용 or 작성자</option>
				</select>
				<input type="text" name="keyword" value="${pageMaker.cri.keyword }" class="keyword">
				<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
				<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
				<button>Search</button>
			</form>
			<table class="tbl_list">
				<tr>
					<th>번호</th>
					<th width="50%">제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td><c:out value="${board.bno}" /></td>
					<td><a href='<c:out value="${board.bno}" />' class="move">
						<c:out value="${board.title}" /></a>
					</td>
					<td><c:out value="${board.writer}" /></td>
					<td><fmt:formatDate value="${board.regDate}" 
					        pattern="yyyy-MM-dd hh:mm:ss" /></td>
					<td><c:out value="${board.cnt}" /></td>
				</tr>
				</c:forEach>
			</table>
			<!-- 페이지 번호 -->
			<div class="pageNum-a">
				<ul>
					<c:if test="${pageMaker.prev }">
					<li class="page-link"><a href="${pageMaker.startPage - 1 }">이전</a></li>
					</c:if>
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" 
				           var="num">
					    <!-- 현재 페이지 -->
					    <c:if test="${pageMaker.cri.pageNum eq num }">
					    	<li class="page-link"><a href="${num }">
					    	<b><c:out value="${num}" /></b></a>
					    	</li>
					    </c:if>
					    <c:if test="${pageMaker.cri.pageNum ne num }">
					    	<li class="page-link">
					    	<a href="${num }"><c:out value="${num}" /></a>
					    	</li>
					    </c:if>
					</c:forEach>
					<c:if test="${pageMaker.next }">
					<li class="page-link"><a href="${pageMaker.startPage + 1 }">이전</a></li>
				</c:if>
				</ul>
			</div>
			<!-- 페이지 처리 전송 폼 -->
			<form action="/board/boardList" method="get" id="actionForm">
				<input type="text" name="pageNum" value="${pageMaker.cri.pageNum}">
				<input type="text" name="amount" value="${pageMaker.cri.amount}">
				<input type="text" name="amount" value="${pageMaker.cri.type}">
				<input type="text" name="amount" value="${pageMaker.cri.keyword}">
			</form>
			<!-- 글쓰기 버튼 -->
			<div class="btn_box">
				<a href="/board/insertBoard"><button type="button">글쓰기</button></a>
			</div>
		</section>
	</div>
<script type="text/javascript">
	$(document).ready(function(){ //제이쿼리 환경
		let actionForm = $("#actionForm");
		//페이지 이동
		$(".page-link a").on("click", function(e){
			e.preventDefault(); //기본 동작 제한(링크 걸리지 않음)
			let targetPage = $(this).attr("href"); //클릭한 페이지
			console.log(targetPage);
			
			actionForm.find("input[name='pageNum']").val(targetPage);
			actionForm.submit();
		});
		
		//상세 페이지로 전송
		$(".move").on("click", function(e){
			e.preventDefault();
			
			let targetBno = $(this).attr("href");
			console.log(targetBno);
			
			actionForm.append("<input type='hidden' name='bno' value='" + targetBno + "'>");
			actionForm.attr("action", "/board/boardView");
			actionForm.submit();
		});
		
		//검색 폼 처리
		let searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			e.preventDefault();
			console.log("click");
			
			searchForm.find("input[name='pageNum']").val(1);	//1페이지부터 검색
			searchForm.submit();
		});
	});
</script>
</body>
</html>