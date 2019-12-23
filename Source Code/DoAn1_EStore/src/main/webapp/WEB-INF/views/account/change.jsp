<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>CHANGE PASSWORD</h1>
	<div class="panel panel-default">
		<div class="panel-heading">${message}</div>
		<div class="panel-body">
			<form action="/account/change" method="post">
				<div class="form-group">
					<label>Username</label>
					<input class="form-control" name="id">
				</div>
				<div class="form-group">
					<label>password</label>
					<input type="password" class="form-control"> 
				</div>
				<div class="form-group">
					<label>new password</label>
					<input type="password" class="form-gourp">
				</div>
				<div class="form-group">
					<label>confirm new password</label>
					<input type="password" class="form-gourp">
				</div>			
				<button class="btn btn-primary">Change</button>
			</form>
		</div>
	</div>
</body>
</html>