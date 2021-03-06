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
    
    <title>完善信息</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap-datetimepicker.min.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
	<script src="${domain}/js/bootstrap-datetimepicker.min.js"></script>
	<script src="${domain}/js/bootstrap-datetimepicker.zh-CN.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">姓名</label><input type="hidden" value="${data.id}" id="id">
							    <input type="text" class="form-control" id="name" placeholder="帐号" value="${data.name}">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">手机号</label>
							    <input type="text" class="form-control" id="phone" placeholder="手机号" value="${data.phone}">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">预约时间</label>
							    <input type="text" class="form-control" value="${data.create_time }" id="datetimepicker">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">备注</label>
							    <textarea id="content" class="form-control">${data.content }</textarea>
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">
$('#datetimepicker').datetimepicker({
    format: 'yyyy-mm-dd hh:ii'
});
function sub(){
var id=$("#id").val();
var name=$("#name").val();
var phone=$("#phone").val();
var create_time=$("#datetimepicker").val();
var content=$("#content").val();
	$.post("${domain}/appointment/update.action", {
		id : id,
		'name' : name,
		'phone' : phone,
		'content' : content,
		'create_time' : create_time,
		},  function(result) {
		layer.msg('修改成功!',{icon:1,time:2000});
	});
}
</script>
</html>