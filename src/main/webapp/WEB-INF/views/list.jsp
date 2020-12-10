<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycompany.myapp.BoardDAO,com.mycompany.myapp.BoardVO,java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<link rel="stylesheet" href="member.css">
<style>
#list {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#list td, #list th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

#list tr:nth-child(even) {
	background-color: #f2f2f2;
}

#list tr:hover {
	background-color: #ddd;
}

#list th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #006bb3;
	color: white;
}
</style>
<script>
	function delete_ok(id) {
		var a = confirm("정말로 삭제하겠습니까?");
		if (a)
			location.href = "deleteok/" + id;
	}
</script>
</head>
<body>
	<!-- test -->
	<h1>자유게시판</h1>

	<table id="list" width="90%">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Regdate</th>
			<th>Good</th>
			<th>Bad</th>
			
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.sid}</td>
				<td>${u.title}</td>
				<td>${u.regdate}</td>
				<td>${u.good}<a href="good/${u.sid}">좋아요</a></td>
				<td>${u.bad}<a href="bad/${u.sid }">싫어요</a></td>
				<td><a href="editform/${u.sid}">Edit</a></td>
				<td><a href="javascript:delete_ok('${u.sid}')">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="add">Add New Post</a>

</body>
</html>