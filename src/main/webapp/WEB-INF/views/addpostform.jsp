<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add New Form</h1>
<form action="addok">
<table>
<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
<tr><td>Photo:</td><td><input type='file'name='photo'/></td></tr>
<tr><td>Password:</td><td><input type="text" name="password"/></td></tr>
<tr><td>Detail:</td><td><textarea cols="50" rows="5" name="detail"></textarea></td></tr>
<tr><td><a href="list">View All Records</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>
</body>
</html>