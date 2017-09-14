<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<table class="dt-table">

				<tr>
					<th>질병 분류 코드</th>
					<td class="text-left" colspan="3"><input
						class="w321 h45 none-border" name="title" value="${detail.classCode}"></td>
				</tr>
				<tr>
					<th>질병 분류 번호</th>
					<td colspan="3">${detail.number}</td>
				</tr>
				<tr>
					<th>질병명</th>
					<td>${detail.name}</td>
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
					<td colspan="4"><textarea class="w850 h104 none-border"
							name="content">${detail.picture }</textarea></td>
			</table>


			<div class="btn-pad">
				<input type="hidden" name="name" value=${ detail.name }>
				<!-- 어떠한 값을 업데이트 할지 -->
				<input type="submit" id="btn" class="btn btn-default" value="저장" />
				<!-- input에 있는 값, key가 있는 값만 전달 -->
				<a href="detail?id=${detail.name }" class="btn btn-default">취소</a>

			</div>
		</form>
	</div>
	</main>

	<!-- footer부분 --> <jsp:include page="../../inc/footer.jsp" />
</body>
</html>