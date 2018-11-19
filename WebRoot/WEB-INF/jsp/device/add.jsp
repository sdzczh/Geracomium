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
    
    <title>添加设备</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">设备名称</label>
							    <input type="text" class="form-control" id="name" placeholder="设备名称">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">管理员编号</label>
							    <input type="text" class="form-control" id="userId" placeholder="管理员编号">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">使用情况</label>
							    <select class="form-control" id="state" name="state">
								<option value="0">未使用</option>
								<option value="1">已使用</option>
								</select>
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">

function sub(){
var userId=$("#userId").val();
var name=$("#name").val();
var state=$("#state").val();
	$.post("${domain}/device/add.action", {
		'name' : name,
		userId : userId,
		state : state
		},  function(result) {
		if(result == 'false'){
			layer.msg('管理员编号输入有误，请重新输入!',{icon:2,time:2000});
			return;
		}else
		layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>