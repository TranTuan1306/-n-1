<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>CHECKOUT</h1>
	<div class="panel panel-default">
		<div class="panel-heading">${message}</div>
		<div class="panel-body">
			<form:form action="/order/purchase" modelAttribute="order">
				<div class="form-group">
					<label>Order Id:</label> 
					<form:input path="id" class="form-control" readonly="true" placeholder="Auto Number"/>
				</div>
				<div class="form-group">
					<label>Customer:</label> 
					<form:input path="customer.id" class="form-control" readonly="true"/>
				</div>
				<div class="form-group">
					<label>Order Date:</label> 
					<form:input path="orderDate" class="form-control" readonly="true"/>
				</div>
				<div class="form-group">
					<label>Amount:</label> 
					<form:input path="amount" class="form-control" readonly="true"/>
				</div>
				<div class="form-group">
					<label>Address:</label> 
					<form:input path="address" class="form-control"/>
				</div>
				<div class="form-group">
					<label>Notes:</label> 
					<form:textarea path="description" class="form-control" rows="4"/>
				</div>
				<button class="btn btn-primary">Purchase</button>
			</form:form>
		</div>
	</div>
</body>
</html>