<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
		<tr class="success">
			<th>Id</th>
			<th>Name</th>
			<th>Unit Price</th>
			<th>Discount</th>
			<th>Quantity</th>
			<th>Product Date</th>
			<th>Special</th>
			<th></th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.unitPrice}</td>
					<td>${item.discount}</td>
					<td>${item.quantity}</td>
					<td>${item.productDate}</td>
					<td>${item.special?'Yes':'No'}</td>
					<td>
						<a class="btn btn-default" href="${acturl}/edit/${item.id}">
							<span class="glyphicon glyphicon-edit"></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>