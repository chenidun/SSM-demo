<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="/ssm/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/ssm/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/ssm/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="/ssm/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="/ssm/static/h-ui.admin/css/style.css" />
<title>用户管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <a id="fresh" class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.reload(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<form action="usersearch.do" method="post">
	<div class="text-c"> 
		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称" id="username" name="username">
		<button type="submit"  class="btn btn-success radius" id="search" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	</form>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a id="delAll" href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a href="usertoadd.do" class="btn btn-primary radius" onClick=""><i class="Hui-iconfont">&#xe600;</i> 添加用户</a></span><span class="r">共有数据：<strong>${sum }</strong> 条</span> </div>
	
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="checkAll" value="" id="checkAll"></th>
				<th width="80">ID</th>
				<th width="100">用户名</th>
				<th width="100">年龄</th>
				<th width="40">性别</th>
				<th width="90">手机</th>
				<th width="150">邮箱</th>
				<th width="">备注</th>
				<th width="130">加入时间</th>
				<th width="60">操作</th>
			</tr>
		</thead>
		<tbody id="user">
		   <c:forEach  items="${list}" var = 'user'>
			<tr id="userTR" class="text-c">
				<td><input type="checkbox" value="${user.uid}" name="check"></td>
				<td>${user.uid }</td>
				<td><a style="cursor:pointer" class="text-primary" href="userdetail.do?uid=${user.uid }" >${user.username }</a></td>
				<td>${user.age }</td>
				<td>${user.sex }</td> 
				<td>${user.mobile }</td>
				<td>${user.email }</td>
				<td>${user.des} </td>
				<td><fmt:formatDate value="${user.jointime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td class="td-manage"> <a title="编辑" href="memberedit.do?uid=${user.uid}" onclick="" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> 
				<a title="删除"  href="javascript:void(0)" onclick="member_del(this,${user.uid})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
			</tr>
		   </c:forEach >
		</tbody>
	</table>
	</div>
<script type="text/javascript" src="/ssm/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="/ssm/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/ssm/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/ssm/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="/ssm/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="/ssm/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="/ssm/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		]
	});
});
/*用户-删除*/
function member_del(obj,uid){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '/ssm/userdelete.do?uid='+uid,
			success: function(data){
				if(data){
				$(obj).parents("tr").remove();
				layer.msg('删除成功!',{icon:1,time:1000,end:function(){
					window.location.reload();
				}});
				}else{
					layer.msg('删除失败！')
				}
			},
		});		
	});
} 
/*批量删除*/
$("#delAll").click(function(){
	obj=document.getElementsByName("check");
	check_val=[];
	for(i in obj){
		if(obj[i].checked)
			check_val.push(obj[i].value);
	}
	//alert("选中的ID是"+check_val)
	//alert(check_val.length);
	if(check_val.length==0){
		layer.msg("请选择至少一项！")
	}else{
	layer.confirm('确认删除吗？',function(index){
		$.ajax({
			type:'POST',
			url:'/ssm/userdeleteall.do?uids='+check_val,
			success:function(data){
				if(data){
					layer.msg("删除成功！",{icon:1,time:1000,end:function(){
						window.location.reload();
					}});
				}else{
					layer.msg("删除失败！")
				}
			}
		});
	});
	}
});
/*用户-查看*/
/* function member_show(title,url,uid,w,h){
	$.post("userdetail.do?uid="+uid)
	layer_show(title,url,w,h);
} */


</script> 
</body>
</html>