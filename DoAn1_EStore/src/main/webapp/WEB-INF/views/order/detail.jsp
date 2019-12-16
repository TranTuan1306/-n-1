<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<h1>ORDER DETAILS</h1>
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
					<form:input path="address" class="form-control" readonly="true"/>
				</div>
				<div class="form-group">
					<label>Notes:</label> 
					<form:textarea path="description" class="form-control" rows="4" readonly="true"/>
				</div>
			</form:form>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Unit Price</th>
						<th>Discount</th>
						<th>Amount</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="d" items="${order.orderDetails}">
						<tr>
							<td>${d.product.id}</td>
							<td>${d.product.name}</td>
							<td>${d.unitPrice}</td>
							<td>${d.discount}</td>
							<td>${d.quantity}</td>
							<td>${d.unitPrice*d.quantity*(1-d.discount)}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>