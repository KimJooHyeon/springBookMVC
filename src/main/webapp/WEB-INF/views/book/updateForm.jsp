<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 수정</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>책 수정</h1>
	<hr/>
	<form action="/book/update" method="post" id="updateForm">
		<p><input type="hidden" name="bookId" value="${bookVo.bookId}" readonly/></p>
		<p>제목 : <input type="text" name="title" value="${bookVo.title}" required/></p>
		<p>카테고리 : <input type="text" name="category" value="${bookVo.category}" required/></p>
		<p>가격 : <input type="text" name="price" value="${bookVo.price}" required/></p>
		<p><input type="hidden" name="insertDate" value="${bookVo.insertDate}" readonly/></p>
	</form>
	<p><a href="#" id="updateSave">저장</a>&nbsp;|&nbsp;<a href="/book/detail?bookId=${bookVo.bookId}">취소</a></p>
	<hr/>
	<a href="/book/list">목록 페이지로 이동</a>&nbsp;|&nbsp;<a href="/book/create">등록 페이지로 이동</a>
	
<script type="text/javascript">
	let updateSave = document.querySelector('#updateSave')
	let updateForm = document.querySelector('#updateForm')
	updateSave.addEventListener('click', function() {
		updateForm.submit()
	})
</script>
</body>
</html>