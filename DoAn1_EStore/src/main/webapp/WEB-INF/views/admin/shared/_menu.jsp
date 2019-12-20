<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
        <div class="navbar navbar-inverse row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
			<!--Menu-->
                <ul class="nav navbar-nav">
                    <li><a href="/home/index"><span class="glyphicon glyphicon-home"></span> Trang chủ</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Quản lý dữ liệu <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        	<li><a href="/admin/product/index">Hàng hóa</a></li>
                        	<li><a href="/admin/category/index">Loại hàng hóa</a></li>
                        	<li><a href="/admin/customer/index">Khách hàng</a></li>
                        	<li><a href="/admin/order/index">Đơn đặt hàng</a></li>
                        </ul>
                    </li>
                </ul>
			<!--Menu-->
            </div>
        </div>
</body>
</html>