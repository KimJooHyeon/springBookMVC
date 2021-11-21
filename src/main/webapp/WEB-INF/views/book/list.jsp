<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
<style type="text/css">
	a {
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>책 목록</h1>
	<hr/>
	<form action="/book/search" method="post">
		<p>
			<select name="searchOption">
				<option value="all">전체</option>
				<option value="title" <c:if test="${searchOption == 'title'}">selected</c:if>>제목</option>
				<option value="category" <c:if test="${searchOption == 'category'}">selected</c:if>>카테고리</option>
			</select>
		
			<input type="text" name="keyword" value="${keyword}" size="9">&nbsp;
			<button type="submit">검색</button>
		</p>
	</form>
	<form action="/book/deleteCheckBox" method="post" id="deleteCheckBoxForm">
		<table border="1">
			<thead>
				<tr>
	<!-- 				<td><input type="checkbox" name="remove" value="all"></td> -->
					<td><a href="#" id="deleteCheckBox">삭제</a></td>
					<td>제목</td>
					<td>카테고리</td>
					<td>가격</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${mapList}">
					<tr>
						<td><input type="checkbox" name="bookIds" value="${row.BOOK_ID}"></td>
						<td><a href="/book/detail?bookId=${row.BOOK_ID}">${row.TITLE}</a></td>
						<td>${row.CATEGORY}</td>
						<td><fmt:formatNumber value="${row.PRICE}" type="number"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<hr/>
	<a href="/book/create">등록 페이지로 이동</a>
	
	<script type="text/javascript">
		let deleteCheckBoxForm = document.querySelector('#deleteCheckBoxForm')
		let deleteCheckBox = document.querySelector('#deleteCheckBox')
		deleteCheckBox.addEventListener('click', function() {
			deleteCheckBoxForm.submit()
		})
	</script>
</body>
</html>