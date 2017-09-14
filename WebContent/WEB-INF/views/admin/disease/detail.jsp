<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"">
<title>공지사항</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css">
<link rel="stylesheet" type="text/css" href="../../css/headfoot.css">
<link rel="stylesheet" type="text/css"
	href="../../css/cscenter/notice.css">
</head>
<jsp:include page="../../inc/header.jsp" />
<div class="space"></div>
<main class="main">
<div class="title">
	<img src="../../images/bg-cscenter.jpg" />
</div>
<div class="nt-container">
		<table class="dt-table">
			<tr>
				<th>질병 분류 코드</th>
				<td class="text-left" colspan="3">${ detail.classCode }${detail.number}</td>
			</tr>
			<tr>
				<th>질병명</th>
				<td colspan="3">${ detail.name}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${detail.explanation }</td>
				
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4">${detail.picture }</td>
		</table>
		<div class="btn-pad2">
			<a href="list" class="btn btn-default">목록</a> <a
				href="edit?name=${detail.name}" class="btn btn-default">수정</a> <a
				href="delete?name=${detail.name }" class="btn btn-default">삭제</a>
		</div>
	</div>
</main>
<jsp:include page="../../inc/footer.jsp" />
</body>
</html>