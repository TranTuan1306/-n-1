$(document).ready(function(){
	$("[data-id-add-to-cart]").click(function(){
		id = $(this).attr("data-id-add-to-cart");
		$.ajax({
			url:"/cart/add/"+id,
			success:function(response){
				$("#cart-cnt").html(response.count);
				$("#cart-amt").html(response.amount);
			}
		});
	});
});