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
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<%@ include file="../layout/header.jsp"%>

<div style="margin-left:100px; margin-right:100px;">
	<form action="/auth/loginProc" method="POST">
		
		<div class="form-group">
			<label for="username">Username:</label> <input type="text" name="username"
				class="form-control" placeholder="Enter username" id="username">
		</div>
		
		<div class="form-group">
			<label for="password">Password:</label> <input type="password" name="password"
				class="form-control" placeholder="Enter password" id="password">
		</div>
		<button id="btn-login" class="btn btn-primary">로그인</button>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=4ea81ebb1a7af90fe6cebf68828e0a42&redirect_uri=http://localhost:8000/auth/kakao/callback
&response_type=code"><img height="38px" src="/image/kakao_login_button.png"></a>
	</form>
</div>
<br>

<%@ include file="../layout/footer.jsp"%>

</html>


