<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Password</th>
			<th>Full Name</th>
			<th>Email Address</th>
			<th>Photo</th>
			<th>Activated</th>
			<th>Role</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${list}">
		<tr>
			<td>${item.id}</td>
			<td>${item.password}</td>
			<td>${item.fullname}</td>
			<td>${item.email}</td>
			<td>${item.photo}</td>
			<td>${item.activated?'Yes':'No'}</td>
			<td>${item.admin?'Admin':'User'}</td>
			<td>
				<a class="btn btn-default" href="${acturl}/edit/${item.id}">
					<span class="glyphicon glyphicon-edit"></span>
				</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>