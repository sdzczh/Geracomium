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
    
    <title>修改个人信息</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">姓名</label><input type="hidden" value="${data.id}" id="id">
							    <input type="text" class="form-control" id="name" placeholder="姓名" value="${data.name }">
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
							  <div class="form-group">
							    <label for="exampleInputEmail1">年龄</label>
							    <input type="text" class="form-control" id="age" placeholder="年龄" value="${data.age }">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">性别</label>
							    <select class="form-control" id="sex" name="sex">
								<option value="0" <c:if test="${data.sex=='0'}">selected="selected"</c:if>>女</option>
								<option value="1" <c:if test="${data.sex=='1'}">selected="selected"</c:if>>男</option>
								</select>
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">

function sub(){
var id=$("#id").val();
var name=$("#name").val();
var password=$("#password").val();
var new1=$("#new").val();
var new2=$("#new1").val();
var age=$("#age").val();
var sex=$("#sex").val();
if(new2 != new1){
	layer.msg('两次输入的新密码不一致!',{icon:2,time:2000});
	return;
}
	$.post("${domain}/userAdmin/update.action", {
		id : id,
		'name' : name,
		'password' : password,
		'new1' : new1,
		age : age,
		sex : sex
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