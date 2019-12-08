<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>FORGOT PASSWORD</h1>
	<div class="panel panel-default">
		<div class="panel-heading">${message}</div>
		<div class="panel-body">
			<form action="/account/forgot" method="post">
				<div class="form-group">
					<label>Username</label>
					<input class="form-control" name="id">
				</div>
				<div class="form-group">
					<label>Email address</label>
					<input class="form-control" name="email"> 
				</div>
				<button class="btn btn-primary">retrieve password</button>
			</form>
		</div>
	</div>
</body>
</html>