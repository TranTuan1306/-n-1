<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>PRODUCT LIST</h1>
	<c:choose>
		<c:when test="${fn:length(prods) == 0}">
			<h2>KHÔNG CÓ SẢN PHẨN NÀO</h2>
		</c:when>
		<c:otherwise>
			<jsp:include page="../shared/_items.jsp"/>
		</c:otherwise>
	</c:choose>
	
</body>
</html>