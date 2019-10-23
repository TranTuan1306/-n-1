<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<h1>PRODUCT LIST</h1>
	<c:forEach var="p" items="${prods}">
		<p><a href="/prod/detail/${p.id}">${p.name}</a> / ${p.unitPrice}</p>
	</c:forEach>
</body>
</html>