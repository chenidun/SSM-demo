<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<div id="modal-reg" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content radius">
			<div class="modal-header">
				<h6 class="modal-title" align="center">注册</h6>
				<a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
			</div>
			<form method="post" class="form form-horizontal" id="member-register"  >
			<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="请输入用户名" id="name" name="name">
			</div>
			</div>
			<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input  type="password" class="input-text" value="" placeholder="请输入密码" id="password" name="password">
			</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" id="register" type="submit">提交</button>
				<button class="btn btn-warning" id="reset" type="reset">重置</button>
				<button class="btn" data-dismiss="modal" aria-hidden="true" id="close">关闭</button>
			</div>
			</form>
		</div>
	</div>
</div>

