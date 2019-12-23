<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
</head>
<body>
	<h1>Category Management</h1>
	<h1 class="label label-success">${message}${param.message}</h1>
	<c:set var="acturl" value="/admin/category" scope="request"/>
	<jsp:include page="_form.jsp"/>
	<jsp:include page="_table.jsp"/>
</body>
</html>