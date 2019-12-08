<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<c:set var="cart" value="${sessionScope['scopedTarget.cart']}"/>
<div class="nn-cart">
<div class="panel panel-default">
    <div class="panel-body">
        <img class="col-sm-5" src="/static/images/shoppingcart.gif" />
        <ul class="col-sm-7">
            <li><span id="cardt-cnt">${cart.count}</span> items</li>
            <li>$ <span id="cart-amt">${cart.amount}</span></li>
             <li><a href="/cart/view">View Cart</a></li>
         </ul>
     </div>
 </div>
</div>
</body>
</html>