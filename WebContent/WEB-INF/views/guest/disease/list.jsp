<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Disease search list</title>
<link rel="stylesheet" type="text/css" href="../css/reset.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

	<jsp:include page="../../inc/header.jsp" />

	<main id="body">

	<div class="content-container">
		<div id="notice-title" class="title">
			<p>질병 검색</p>
		</div>
		<c:set var="num1" value="감염성 및 기생충 질환" />
		<c:set var="num2" value="항문,장 질환" />
		<c:set var="num3" value="비뇨기 질환" />
		<c:set var="num4" value="기타 질환" />
		<c:set var="cate" value="${ param.c}" />
		<c:set var="t" value="${ param.t}" />
		
		<div class="as-list aside">
			<h1 class="hidden">선택</h1>
		
			<ul>
				<li><a href="disease-list">전체</a></li>
				<li><a href="disease-list?c=${num1}">감염성 및 기생충 질환</a></li>
				<li><a href="disease-list?c=${num2}">항문,장 질환</a></li>
				<li><a href="disease-list?c=${num3}">비뇨기 질환</a></li>
				<li><a href="disease-list?c=${num4}">기타 질환</a></li>
			</ul>
		</div>
	
		<div align="center">
			<nav id="search-form">
			<h1 class="hidden">강좌검색 폼</h1>
			<form action="disease-list?c= ${sh.value }&t=${ttt.value}" method="get">
				<select name="c" id="sh">
					<option value="">전체</option>
					<option value="${num1}">감염성 및 기생충 질환</option>
					<option value="${num2}">항문,장 질환</option>
					<option value="${num3}">비뇨기 질환</option>
					<option value="${num4}">기타 질환</option>
				</select> <input type="text" id="ttt" name="title"/> <input class="btn btn-img btn-search"
					type="submit" value="검색" />
			</form>
			</nav>
		</div>

		
			<table class="table table-list">
				<tr>
					<th class="w60">분류</th>
					<th class="w60">번호</th>
					<th class="w100">이름</th>
					<th class="w100">내용</th>
					<th class="w60">사진</th>
				</tr>
				<c:forEach var="n" items="${list}">
					<tr>
					<!-- class="title text-left text-indent" (넘버 td에 있던거 -->
						<td>${ n.classCode }</td>
						<td>${n.number}</td>
						<td>${ n.name}</td>
						<td>${ n.explanation }</td>
						<td>${ n.picture }</td>
					</tr>
				</c:forEach>
			</table>

			<%-- ${fn:substringBefore((count/10),'.')} --%>
			<%-- <fn:substringBefore("23.45",",")/> --%>
			<c:set var="page" value="${param.p}" />
			<c:set var="startNum" value="${page-((page-1)%5) }" />
			<c:set var="lastNum"
				value="${fn:substringBefore((count%10 == 0 ? count/10 : count/10 +1),'.')}" />
			<!-- 조건문 ? 참일때 : 거짓일 때  -->
			<%-- <c:set var="lastNum" value="${count/10}"/> --%>
			
			<br />
			<div>
				<div>
					<c:if test="${startNum != 1 }">
						<a href="?p=${startNum-1}">이전</a>
					</c:if>
				</div>
				<ul>
					<c:forEach var="i" begin="0" end="4">

						<c:set var="strong" value="" />
						<c:if test="${page == startNum+i }">
							<c:set var="strong" value="text-strong" />
						</c:if>

						<c:if test="${startNum+i <= lastNum}">
							<li><a class="${strong}" href="?p=${startNum+i}&c=${cate}&title=${param.title}">${startNum+i}</a></li>
						</c:if>

						

						<!-- 	목록이 더이상 없으면 하이퍼링크 지움 -->
						<c:if test="${startNum+i > lastNum}">
							<li>${startNum+i}</li>
						</c:if>
					</c:forEach>
				</ul>
				<div>
					<c:if test="${lastNum >= startNum+5 }">
						<a href="?p=${startNum+5}">다음</a>
						<!-- 게시물 목록이 다 끝나면 다음이 안보임  -->
					</c:if>
				</div>

			</div>
	</div>
	</main>
	


	<jsp:include page="../../inc/footer.jsp" />
</body>
</html>