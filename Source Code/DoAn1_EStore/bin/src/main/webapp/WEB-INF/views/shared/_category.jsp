<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="glyphicon glyphicon-th-list"></span>
                        <strong>Chủng loại</strong>
                    </div>

                    <div class="list-group">
                    <c:forEach var="c" items="${cates}">
                        <a href="/prod/list-by-cate/${c.id}" class="list-group-item">${c.nameVN}</a>
                    </c:forEach>
                    </div>
                </div>
</body>
</html>