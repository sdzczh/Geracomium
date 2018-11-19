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
    
    <title>添加护工</title>
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
							    <label for="exampleInputEmail1">食品名称</label>
							    <input type="text" class="form-control" id="name" placeholder="食品名称">
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">价格</label>
							    <input type="text" class="form-control" id="price" placeholder="价格">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">生产日期</label>
							    <input type="text" class="form-control" id="datetimepicker">
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
var price=$("#price").val();
var name=$("#name").val();
var datetimepicker=$("#datetimepicker").val();
	$.post("${domain}/diet/add.action", {
		'price' : price,
		'name' : name,
		'create_time' : datetimepicker,
		},  function(result) {
			layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>