<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Shopping cart</title>
</head>
<body>
	<h1>YOUR SHOPPING CART</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Unit Price</th>
				<th>Discount</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th></th>
			</tr>
		</thead>
		<tbody class="nn-cart-items">
			<c:forEach var="p" items="${cart.items}">
				<tr>
					<td>${p.id}</td>
					<td>${p.name}</td>
					<td>${p.unitPrice}</td>
					<td>${p.discount}</td>
					<td><input data-update-info="${p.id}~${p.discount}~${p.unitPrice}" value="${p.quantity}" type="number" min="1" style = "width:60px"></td>
					<td class="nn-amt">${p.quantity * p.unitPrice * (1-p.discount)}</td>
					<td>
						<button class="btn btn-info btn-sm" data-id-remove-from-cart="${p.id}">
							<span class="glyphicon glyphicon-trash"></span>
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div>
		<a href="" class="btn btn-danger btn-lg">
			<span class="glyphicon glyphicon-hand-left"></span> Continue
		</a>
		<a href="" class="btn btn-info btn-lg nn-clear">
			<span class="glyphicon glyphicon-trash"></span> clear
		</a>
		<a href="/order/checkout" class="btn btn-success btn-lg">
			<span class="glyphicon glyphicon-hand-right"></span> check out
		</a>
	</div>
</body>
</html>