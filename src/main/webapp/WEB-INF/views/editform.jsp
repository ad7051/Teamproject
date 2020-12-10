<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycompany.myapp.BoardDAO,com.mycompany.myapp.BoardVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Form</h1>
	<form:form method="POST" action="../editok" modelAttribute="u">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="sid" /></td>
			</tr>
			<tr>
				<td>Title :</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Detail :</td>
				<td><form:input path="detail" /></td>
			</tr>
				<td>Photo :</td>
				<td><img src="photo"></td>
				<tr><td>Photo:</td><td><input type='file'name='photo'/></td></tr>
				
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /><input
					type="button" value="Cancel" onclick="history.back()" /></td>
			</tr>
		</table>
	</form:form>


</body>
</html>