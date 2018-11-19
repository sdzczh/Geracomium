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
    
    <title>添加记录</title>
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
							    <label for="exampleInputEmail1">姓名</label>
							    <input type="text" class="form-control" id="name" placeholder="姓名">
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">手机号</label>
							    <input type="text" class="form-control" id="phone" placeholder="手机号">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">预约时间</label>
							    <input type="text" class="form-control" id="datetimepicker">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">备注</label>
							    <textarea id="content" class="form-control"></textarea>
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
var userId=$("#userId").val();
var bedId=$("#bedId").val();
var state=$("#state").val();
var datetimepicker=$("#datetimepicker").val();
var datetimepicker2=$("#datetimepicker2").val();
	$.post("${domain}/appointment/add.action", {
		userId : userId,
		bedId : bedId,
		state : state,
		'create_time' : datetimepicker,
		'exit_time' : datetimepicker2,
		},  function(result) {
		layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>