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
    
    <title>添加床类型</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							   <div class="form-group">
							    <label for="exampleInputEmail1">类型名称</label>
							    <input type="text" class="form-control" id="name" placeholder="类型名称">
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">价格</label>
							    <input type="text" class="form-control" id="price" placeholder="价格">
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">

function sub(){
var name=$("#name").val();
var price=$("#price").val();
	$.post("${domain}/bedType/add.action", {
		'name' : name,
		'price' : price,
		},  function(result) {
		layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>