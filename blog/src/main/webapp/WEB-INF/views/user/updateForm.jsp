<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>lyu's 블로그</title>
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
	<form style="margin-left:100px; margin-right:100px;">
	<input type="hidden" id = "id" value="${principal.user.id}">
		<div class="form-group">
			<label for="username">Username:</label>
			 <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username"readOnly>
		</div>
		
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		
		<div class="form-group">
			<label for="email">Email address:</label>
			<input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button style="margin-left:100px;" id="btn-update" class="btn btn-primary">회원수정완료</button>
	<br>
</div>
<script src="/js/user.js"> </script>

<%@ include file="../layout/footer.jsp"%>

</html>


