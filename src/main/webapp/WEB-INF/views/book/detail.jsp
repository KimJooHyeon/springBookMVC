<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>책 상세</h1>
	<hr/>
	<p>제목 : ${bookVo.title}</p>
	<p>카테고리 : ${bookVo.category}</p>
	<p>가격 : <fmt:formatNumber value="${bookVo.price}" type="number"/></p>
	<p>입력일 : <fmt:formatDate value="${bookVo.insertDate}" pattern="yyyy.MM.dd"/></p>
	<p><a href="/book/update?bookId=${bookVo.bookId}">수정</a>&nbsp;|&nbsp;<a href="/book/delete?bookId=${bookVo.bookId}">삭제</a></p>
	<hr/>
	<a href="/book/list">목록 페이지로 이동</a>&nbsp;|&nbsp;<a href="/book/create">등록 페이지로 이동</a>
</body>
</html>