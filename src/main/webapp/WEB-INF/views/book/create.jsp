<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 등록</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>책 등록</h1>
	<hr/>
	<form action="/book/detail" method="post">
		<p>제목 : <input type="text" name="title"/></p>
		<p>카테고리 : <input type="text" name="category"/></p>
		<p>가격 : <input type="text" name="price"/></p>
		<p><input type="submit" value="저장"/></p>
	</form>
	<hr/>
	<a href="/book/list">목록 페이지로 이동</a>
</body>
</html>