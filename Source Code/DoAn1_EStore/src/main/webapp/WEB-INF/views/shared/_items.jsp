<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
	<c:forEach var="p" items="${prods}">
		<div class="col-sm-4">
			<div class="panel panel-default nn-prod">
				<div class="panel-heading">${p.name}</div>
				<div class="panel-body">
					<a href="/prod/detail/${p.id}">
						<img src="/static/images/products/${p.image}">
					</a>
				</div>
				<div class="panel-footer">
					<div class="row">
						<div class="col-sm-3">${p.unitPrice}$</div>
						<div class="col-sm-9 text-right">
							<button class="btn btn-sm btn-primary" data-id-add-to-cart="${p.id}">
								<span class="glyphicon glyphicon-shopping-cart"></span>
							</button>
							<button class="btn btn-sm btn-danger" data-id-mark-as-favorite="${p.id}">
								<span class="glyphicon glyphicon-heart"></span>
							</button>
							<button class="btn btn-sm btn-info" data-id-send-to-friend="${p.id}" data-toggle="modal" data-target="#myModal">
								<span class="glyphicon glyphicon-envelope"></span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
<jsp:include page="_modal.jsp"></jsp:include>

</body>
</html>