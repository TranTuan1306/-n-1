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
	
	$(".nn-clear").click(function(){
		$.ajax({
			url:"/cart/clear",
			success:function(response){
				$("#cart-cnt").html(0);
				$("#cart-amt").html(0);
			}
		});
		var trs = $(".nn-cart-items").find("tr");
		for(var i=trs.length-1; i >= 0;i--){
			$(trs.get(i)).hide(500);
		}
	});
	
	$("[data-id-remove-from-cart]").click(function(){
		id = $(this).attr("data-id-remove-from-cart");
		$.ajax({
			url:"/cart/remove/"+id,
			success:function(response){
				$("#cart-cnt").html(response.count);
				$("#cart-amt").html(response.amount);
			}
		});
		$(this).parents("tr").hide(500);
	});
	
	$("[data-id-send-to-friend]").click(function(){
		id = $(this).attr("data-id-send-to-friend");
	});
	
	$("[data-id-send]").click(function(){
		from = $("#sender").val();
		to = $("#receiver").val();
		subject = $("#subject").val();
		content = $("#content").val();
		$.ajax({
			url:"/prod/send-to-friend/"+id,
			data:{from: from, to: to, subject: subject, content: content},
			success:function(response){
				alert(response);
			}
		});
	});
	
});

