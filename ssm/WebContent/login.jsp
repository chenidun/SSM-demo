<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/register.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="/ssm/static/h-ui/css/H-ui.min.css" rel="stylesheet"
	type="text/css" />
<link href="/ssm/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet"
	type="text/css" />
<link href="/ssm/static/h-ui.admin/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="/ssm/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet"
	type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>登录</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<form class="form form-horizontal" action="" id="adminlogin"
				method="post">
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-xs-8">
						<input id="name" name="name" type="text" placeholder="账户"
							class="input-text size-L">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-xs-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row cl" >
					<div class="formControls col-xs-8 col-xs-offset-3">
						<input name="" type="submit" class="btn btn-success radius size-L"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
						<input name="" type="reset" class="btn btn-warning radius size-L"
							value="&nbsp;重&nbsp;&nbsp;&nbsp;&nbsp;置&nbsp;">	 
						<input name="" onClick="modalreg()" class="btn btn-primary radius size-L"
							value="&nbsp;注&nbsp;&nbsp;册&nbsp;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.form.js"></script>
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript">
	/* 登陆*/
		var option = {
			url : '/ssm/adminlogin.do',
			success : function(data) {
				if (data) {
					layer.msg("登录成功", {
						icon : 1,
						time : 1000,
						end : function() {
							window.location.href = "toindex.do"
						}
					});
				} else {
					layer.msg("登录失败，请重新检查账户密码")
				}
			},
		}
		$("#adminlogin").ajaxForm(option);
	/*打开注册窗口 */
	function modalreg(){
		$("#modal-reg").modal("show")
	}
	/* 注册表单提交*/
	var options={
			url:'/ssm/admin_register.do',
			success:function(data){
				if(data){
					layer.msg("注册成功",{icon:1,time:1000,end:function(){
						$("#close").click();
						
					}})
				}else{
					layer.msg("注册失败")
				}
			}
	}
	$("#member-register").ajaxForm(options);
	</script>
</body>
</html>