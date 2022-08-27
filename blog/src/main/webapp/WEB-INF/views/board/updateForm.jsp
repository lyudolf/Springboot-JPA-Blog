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
		<form>
		<input type="hidden" id="id" value="${board.id}"/>
			<div class="form-group">
				<input value="${board.title}" type="text" class="form-control" placeholder="제목을 입력하세요" id="title">
			</div>

			<div class="form-group">
				<textarea class="form-control summernote" rows="5" id="content">${board.content}</textarea>
			</div>
			
		</form>
		<button id="btn-update" class="btn btn-primary">수정완료</button>
	</div>
	<br>
</div>
    <script>
      $('.summernote').summernote({
        placeholder: '내용을 입력하세요',
        tabsize: 2,
        height: 300
      });
    </script>
    <script src="/js/board.js"> </script>
<%@ include file="../layout/footer.jsp"%>

</html>


