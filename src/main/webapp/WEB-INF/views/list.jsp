<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page
	import="com.mycompany.myapp.BoardDAO,com.mycompany.myapp.BoardVO,java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pixtagram</title>
<link rel="stylesheet" href="../resources/css/creation3.css">
<script>
	function delete_ok(id) {
		var a = confirm("정말로 삭제하겠습니까?");
		if (a)
			location.href = "deleteok/" + id;
	}
</script>
</head>
<body>
	<div id='back'>
		<div id='header'>
			<img id='logo' src='../resources/img/pixtagram.png'> <a
				class='addbutton' href="add">Add New Post</a>
		</div>
		<div class='main'>

			<div id="list">

				<c:forEach items="${list}" var="u">
					<div id='tr' style="cursor: pointer;"
						onclick="location.href='view/${u.sid}';">
						<div id='image'>
							<div class='wrapper'>
								<div class='thumbnail'>
									<div class='center'>
										<img class='test' src="../resources/img/loginimage.png">
									</div>
								</div>
							</div>
						</div>
						<div id='title'>${u.title}</div>
						<div id='num'>no.${u.sid}</div>

						<div id='like'>like : <a class=lbutton href="good/${u.sid}">좋아요</a></div>
						<div id='dislike'>dislike : <a class=lbutton href="bad/${u.sid }">싫어요</a></div>
						<div id='t_button'>
							<div id='edit_wrap'>
								<a class='edit' href="editform/${u.sid}">Edit</a>
							</div>
							<div>
								<a class='delete' href="javascript:delete_ok('${u.sid}')">Delete</a>
							</div>
						</div>
						<div id='upload'>upload : ${u.regdate}</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>

</body>
</html>