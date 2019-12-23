<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<h1>LOGIN</h1>
	<div class="panel panel-default">
		<div class="panel-heading">${message}</div>
		<div class="panel-body">
			<form action="/account/login" method="post">
				<div class="form-group">
					<label>User Name</label>
					<input value="${username}" class="form-control" name="id">
				</div>
				
				<div class="form-group">
					<label>Password</label>
					<input value="${password}" type="password" class="form-control" name="password">
				</div>
				
				<div class="checkbox">
					<label><input type="checkbox" name="remember">Remember me?</label>
				</div>
				<button class="btn btn-prinmary">Login</button>
			</form>			
		</div>
	</div>
</body>
</html>