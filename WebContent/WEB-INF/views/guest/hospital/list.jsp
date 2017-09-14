<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>병원 검색</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css">
<link rel="stylesheet" type="text/css"
	href="../../css/main/counseling.css">
<link rel="stylesheet" type="text/css" href="../../css/headfoot.css">

</head>
<body>

	<jsp:include page="../../inc/header.jsp" />

	<main class="main">
	<div class="title">
		<p>질병 검색</p>

		<c:set var="num1" value="외과" />
		<c:set var="num2" value="비뇨기과" />
		<c:set var="num3" value="산부인과" />
		<c:set var="num4" value="기타" />

		<c:set var="ad1" value="서울" />
		<c:set var="ad2" value="부산" />
		<c:set var="ad3" value="대구" />
		<c:set var="ad4" value="인천" />
		<c:set var="ad5" value="광주" />
		<c:set var="ad6" value="대전" />
		<c:set var="ad7" value="울산" />
		<c:set var="ad8" value="세종" />
		<c:set var="ad9" value="경기도" />
		<c:set var="ad10" value="강원도" />
		<c:set var="ad11" value="충청북도" />
		<c:set var="ad12" value="충청남도" />
		<c:set var="ad13" value="전라북도" />
		<c:set var="ad14" value="전라남도" />
		<c:set var="ad15" value="경상북도" />
		<c:set var="ad16" value="경상남도" />
		<c:set var="ad16" value="제주" />

		<div class="as-list aside">
			<h1 class="hidden">선택</h1>

			<ul>
				<li><a href="hospital-list">전체</a></li>
				<li><a href="hospital-list?c=${num1}">항외과</a></li>
				<li><a href="hospital-list?c=${num2}">비뇨기과</a></li>
				<li><a href="hospital-list?c=${num3}">산부인과</a></li>
				<li><a href="hospital-list?c=${num4}">기타</a></li>
			</ul>
		</div>
		<c:set var="tt" value="${param.title}" />
		<c:set var="c" value="${param.c}" />
		<div align="center">
			<nav id="search-form">
			<h1 class="hidden">강좌검색 폼</h1>
			<form
				action="hospital-list?c=${sh.value }&t=${param.tt}&a=${ad.value}"
				method="get">
				<select name="a" id="ad">
					<option value="">시도 선택</option>
					<option value="${ad1}">서울특별시</option>
					<option value="${ad2}">부산광역시</option>
					<option value="${ad3}">대구광역시</option>
					<option value="${ad4}">인천광역시</option>
					<option value="${ad5}">광주광역시</option>
					<option value="${ad6}">대전광역시</option>
					<option value="${ad7}">울산광역시</option>
					<option value="${ad8}">세종특별자치시</option>
					<option value="${ad9}">경기도</option>
					<option value="${ad10}">강원도</option>
					<option value="${ad11}">충청북도</option>
					<option value="${ad12}">충청남도</option>
					<option value="${ad13}">전라북도</option>
					<option value="${ad14}">경상북도</option>
					<option value="${ad15}">경상남도</option>
					<option value="${ad16}">제주특별자치도</option>

				</select> <select name="c" id="sh">
					<option value="">진료 과목 선택</option>
					<option value="${ num1}">항외과</option>
					<option value="${num2}">비뇨기과</option>
					<option value="${num3}">산부인과</option>
					<option value="${num4}">기타</option>
				</select> <input type="text" name="title" /> <input
					class="btn btn-img btn-search" type="submit" value="검색" />
			</form>
			</nav>
		</div>


		<table class="table table-list">
			<tr>
				<th class="w60">번호</th>
				<th class="w60">진료 과목</th>
				<th class="w100">병원 이름</th>
				<th class="w100">주소</th>
				<th class="w60">전화번호</th>
			</tr>
			<c:forEach var="n" items="${list}">
				<tr>
					<!-- class="title text-left text-indent" (넘버 td에 있던거 -->
					<td>${ n.number }</td>
					<td>${n.subject}</td>
					<td>${ n.name}</td>
					<td>${ n.address }</td>
					<td>${ n.phoneNumber }</td>
				</tr>
			</c:forEach>
		</table>

		<%-- ${fn:substringBefore((count/10),'.')} --%>
		<%-- <fn:substringBefore("23.45",",")/> --%>
		<c:set var="page" value="${param.p}" />
		<!-- getparameter에서 p값 얻는 방법 : param.p -->
		<c:set var="startNum" value="${page-((page-1)%5) }" />
		<c:set var="lastNum"
			value="${fn:substringBefore((count%10 == 0 ? count/10 : count/10 +1),'.')}" />
		<c:set var="cate" value="${param.c}" />
		<c:set var="addr" value="${param.a}" />

		<!-- 조건문 ? 참일때 : 거짓일 때  -->
		<%-- <c:set var="lastNum" value="${count/10}"/> --%>

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
						<li><a class="${strong}"
							href="?c=${cate}&p=${startNum+i}&title=${tt}&a=${addr}">${startNum+i}</a></li>
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