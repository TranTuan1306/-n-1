<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>REGISTRATION</h1>
	<div class="panel panel-default">
		<div class="panel-heading">${message}</div>
		<div class="panel-body">
			<form:form action="/account/register" 
				enctype="multipart/form-data" modelAttribute="user">
				<div class="form-group">
					<label>Username:</label> 
					<form:input path="id" class="form-control"/>
					<form:errors path="id"/>
				</div>
				<div class="form-group">
					<label>Password:</label> 
					<form:input path="password" class="form-control"/>
					<form:errors path="password"/>
				</div>
				<div class="form-group">
					<label>Email Address:</label> 
					<form:input path="email" class="form-control"/>
					<form:errors path="email"/>
				</div>
				<div class="form-group">
					<label>Fullname:</label> 
					<form:input path="fullname" class="form-control"/>
					<form:errors path="fullname"/>
				</div>
				<div class="form-group">
					<label>Photo:</label> 
					<input type="file" name="_photo" class="form-control">
					<form:hidden path="photo"/>
				</div>
				<button class="btn btn-primary">Sign Up</button>
			</form:form>
		</div>
	</div>
</body>
</html>