<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 글등록</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/headfoot.css" type="text/css" rel="stylesheet" />
<link href="../../css/cscenter/notice.css" type="text/css"
	rel="stylesheet" />
</head>
<body>
	<!-- header 부분 -->
	<jsp:include page="../../inc/header.jsp" />
	<div class="space"></div>
	<main class="main">
	<div class="title">
		<img src="../../images/bg-cscenter.jpg" />
	</div>
	<div class="nt-container">
		<form method="post">
			<table class="table">
			<tr>
				<th scope="row">질병 분류 코드</th>
				<td><input class="w321 h45 none-border" type="text"
					name="code" /></td>
			</tr>
			<tr>
				<th scope="row">질병 분류 번호</th>
				<td><input class="w321 h45 none-border" type="text"
					name="number" /></td>
			</tr>
			<tr>
				<th scope="row">질병명</th>
				<td class="w850 h45" colspan="3"><input class="w321 h45 none-border" type="text"
					name="name" /></td>
			</tr>
			<tr>
				<th scope="row">내용</th>
				<td colspan="3"><textarea class="w850 h104 none-border"
						rows="5" cols="100" name="explanation"></textarea></td>
			</tr>
			<tr>
				<th scope="row">첨부파일</th>
				<td class="w850 h45" colspan="3">파일</td>
			</tr>
		</table>
		<div class="btn-pad4">
			<input id="insert-button" type="submit" value="등록" class="btn btn-default" />
		</div>
		</form>
	</div>
	</div>
	</main>

<jsp:include page="../../inc/footer.jsp" />
</body>
</html>