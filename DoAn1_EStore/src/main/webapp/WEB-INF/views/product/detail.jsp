<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<h1>PRODUCT DETAILS</h1>
	
	<div class="row">
		<div class="col-sm-5"><img src="/static/images/products/${prod.image}"></div>
		<div class="col-sm-7">
			<ul>
				<li>Name: ${prod.name}</li>
				<li>Unit Price: $<f:formatNumber value="${prod.unitPrice}" pattern="#,###.00"/></li>
				<li>Product Date: <f:formatDate value="${prod.productDate}" pattern="dd-MM-yyyy"/></li>
				<li>Special: ${prod.special?'Yes':'No'}</li>
				<li>Category: ${prod.category.nameVN}</li>
				<li>Discount: ${prod.discount}</li>
				<li>View Count: ${prod.viewCount}</li>
				<li>Available: ${prod.available}</li>
			</ul>
		</div>
	</div>

	<hr>
	<h3>HÀNG CÙNG LOẠI</h3>
	<c:forEach var="p" items="${prod.category.products}">
		<p><a href="/prod/detail/${p.id}">${p.name}</a> / ${p.unitPrice}</p>
		<img class="dList-img" src="/static/images/products/${p.image}">
	</c:forEach>
</body>
</html>