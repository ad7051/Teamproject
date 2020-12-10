<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
<link rel="stylesheet" href="../resources/css/creation5.css">
</head>
<body>
<div id='back'>
		<div id='header'>
			<a href="list"><img id='logo' src='../resources/img/pixtagram.png'></a>
		</div>
		<div class='main'>
			<div id='leftgap'>
				<a class='button' href="list">Cancel</a>
			</div>
			<div id='mid'>
				<form method="POST" action="addok">
					<div id='mid-top'>
						<div id='titled'>Title : <input type='text' name="title" id='title'/></div>
						<div id='num'></div>
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
						<div id='content'>Detail : <input type='text' name="detail" id='detail'/></div>
						<div id='password'>Password : <input type="text" name="password" id='detail'/></div>
					</div>
				</form>
			</div>
			<div id='rightgap'>
				<input class='submitbutton' type="submit" value="Add post" />
			</div>
		</div>
	</div>

</body>
</html>