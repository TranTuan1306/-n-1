<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="form" action="${acturl}/index" enctype="multipart/form-data">
		<div class="form-group">
			<label>Id</label>
			<form:input path="id" class="form-control" readonly="true"/>
			<form:errors path="id"/>
		</div>
		
		<div class="form-group">
			<label>Name</label>
			<form:input path="name" class="form-control"/>
			<form:errors path="name"/>
		</div>
		
		<div class="form-group">
			<label>Name Việt Nam</label>
			<form:input path="nameVN" class="form-control"/>
			<form:errors path="nameVN"/>
		</div>

		<div class="form-group">
			<button class="btn btn-default" formaction="${acturl}/create" ${!empty form.id ? 'disabled':''}>
				<span class="glyphicon glyphicon-log-in"></span> Create			
			</button>
			<button class="btn btn-default" formaction="${acturl}/update" ${empty form.id ? 'disabled':''}>
				<span class="glyphicon glyphicon-log-in"></span> Update			
			</button>
			<button class="btn btn-default" formaction="${acturl}/delete" ${empty form.id ? 'disabled':''}>
				<span class="glyphicon glyphicon-log-in"></span> Delete			
			</button>
			<a href="${acturl}/index"  class="btn btn-default">
				<span class="glyphicon glyphicon-log-in"></span> Reset			
			</a>
		</div>
	</form:form>
</body>
</html>