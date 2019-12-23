<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>YOUR ORDER LIST</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Order Date</th>
				<th>Address</th>
				<th>Amount</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="o" items="${orders}">
			<tr>
				<td>${o.id}</td>
				<td>${o.orderDate}</td>
				<td>${o.address}</td>
				<td>${o.amount}</td>
				<td>
					<a href="/order/detail/${o.id}" class="btn btn-sm btn-info">
						<span class="glyphicon glyphicon-search"></span>
					</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>