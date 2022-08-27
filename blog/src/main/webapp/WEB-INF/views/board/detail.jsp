<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<%@ include file="../layout/header.jsp"%>


<div class="container">
	<div style="margin-left: 100px; margin-right: 100px;">

		<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<c:if test="${board.user.id == principal.user.id }">
			<a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
			<button id="btn-delete" class="btn btn-danger">삭제</button>
		</c:if>
		<br>
		<br>
		<div>
			글 번호: <span id="id"><i>${board.id} </i></span>
			작성자: <span><i>${board.user.username} </i></span>
		</div>
		<br>
		<div class="form-group">
			<h3>${board.title}</h3>
		</div>
		<hr>
		<div class="form-group">
			<div>${board.content}</div>
		</div>
	</div>
	<br>
</div>

<script src="/js/board.js">
	
</script>
<%@ include file="../layout/footer.jsp"%>

</html>


