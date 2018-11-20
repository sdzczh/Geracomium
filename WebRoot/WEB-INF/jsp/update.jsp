<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">用户名</label>
							    <input type="text" class="form-control" id="account" placeholder="用户名">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">旧密码</label>
							    <input type="password" class="form-control" id="password" placeholder="旧密码">
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">新密码</label>
							    <input type="password" class="form-control" id="new" placeholder="新密码">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">确认新密码</label>
							    <input type="password" class="form-control" id="new1" placeholder="确认新密码">
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">

function sub(){
var account=$("#account").val();
var password=$("#password").val();
var new1=$("#new").val();
var new2=$("#new1").val();
if(new2 != new1){
	layer.msg('两次输入的新密码不一致!',{icon:2,time:2000});
	return;
}
	$.post("${domain}/admin/update.action", {
		'account' : account,
		'password' : password,
		'new1' : new1,
		},  function(result) {
		if(result == 'false'){
			layer.msg('旧密码或账号错误!',{icon:2,time:2000});
			return;
		}else
			layer.msg('修改成功!',{icon:1,time:2000});
			return;
	});
}
</script>
</html>