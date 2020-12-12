<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
<link rel="stylesheet" href="../../resources/css/creation5.css">
</head>
<body>
<%

System.out.println("path: "+request.getServletContext().getRealPath("upload"));
System.out.println("filename"+request.getAttribute("photo"));
String p1=request.getServletContext().getRealPath("upload");


String path=p1+"\\"+request.getAttribute("photo");
System.out.println(path);
request.setAttribute("path",path);
%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div id='back'>
		<div id='header'>
			<a href="../list"><img id='logo' src='../../resources/img/pixtagram.png'></a>
		</div>
		<div class='main'>
			<div id='leftgap'>
				<a class='button' href="../list">Cancel</a>
			</div>
			<div id='mid'>
				<div id='mid-top'>
					<div id='titled'>${u.title}</div>
					<div id='num'>no.${u.sid}</div>
				</div>
				<div id='mid-center'>
					<div id='image'>
						<div class='wrapper'>
							<div class='thumbnail'>
								<div class='center'>
									<img class="test"src="${path}">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id='mid-bottom'>
					<div id='content'>${u.detail}</div>
					<div id='like'>like : ${u.good}</div>
					<div id='dislike'>dislike :${u.bad}</div>
				</div>
			</div>
			<div id='rightgap'></div>
		</div>
	</div>

</body>
</html>