<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<body>
	<div class="nn-cart">
	    <div class="panel panel-default">
	        <div class="panel-body">
	            <form method="post" action="/prod/list-by-keywords">
	                <input value="${param.keywords}" placeholder="Keywords" name="keywords" class="form-control" />
	            </form>
	        </div>
	    </div>
	</div>
</body>
</html>	