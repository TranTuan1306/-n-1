<%@ page pageEncoding="utf-8"%>
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Gửi thông tin hàng hóa cho bạn bè</h4>
      </div>
      <div class="modal-body">
        <form action="">
			<div class="form-group">
			  <label for="email">Người gửi:</label>
			  <input class="form-control" id="sender">
			</div>
			<div class="form-group">
			  <label for="email">Người nhận:</label>
			  <input class="form-control" id="receiver">
			</div>
			<div class="form-group">
			  <label for="email">Tiêu đề:</label>
			  <input class="form-control" id="subject">
			</div>
			<div class="form-group">
			  <label for="email">Nội dung:</label>
			  <textarea class="form-control" id="content" rows="3"></textarea>
			</div>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn btn-default" data-id-send="1005">Gửi</button>
      </div>
    </div>

  </div>
</div>