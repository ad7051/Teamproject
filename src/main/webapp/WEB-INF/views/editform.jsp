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
<title>Edit</title>
<link rel="stylesheet" href="../../resources/css/creation5.css">
</head>
<body>
	<div id='back'>
		<div id='header'>
			<a href="../list"><img id='logo' src='../../resources/img/pixtagram.png'></a>
		</div>
		<div class='main'>
			<div id='leftgap'>
				<a class='button' href="../list">Cancel</a>
			</div>
			<div id='mid'>
				<form:form method="POST" action="../editok" modelAttribute="u">
					<div id='mid-top'>
						<div id='titled'>Title : <form:input type='text' path="title" /></div>
						<div id='num'><form:hidden path="sid" /></div>
					</div>
					<div id='mid-center'>
						<div id='image'>
							<div class='wrapper'>
								<div class='thumbnail'>
									<div class='center'>
										<img src="photo">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id='mid-bottom'>
						<div id='photoinput'>Photo : <input type='file' name='photo' /></div>
						<div id='content'>Detail : <form:input path="detail" /></div>
					</div>
				</form:form>
			</div>
			<div id='rightgap'>
				<input class='submitbutton' type="submit" value="Edit" />
			</div>
		</div>
	</div>



</body>
</html>