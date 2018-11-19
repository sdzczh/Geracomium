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
    
    <title>添加员工</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							   <div class="form-group">
							    <label for="exampleInputEmail1">老人编号</label>
							    <input type="text" class="form-control" id="userId" placeholder="老人编号">
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">类型编号</label>
							    <input type="text" class="form-control" id="type" placeholder="类型编号">
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">

function sub(){
var userId=$("#userId").val();
var type=$("#type").val();
	$.post("${domain}/bed/add.action", {
		type : type,
		userId : userId,
		},  function(result) {
		if(result == 'false'){
			layer.msg('老人编号输入有误，请重新输入!',{icon:2,time:2000});
			return;
		}else if(result == 'error'){
			layer.msg('床类型输入有误，请重新输入!',{icon:2,time:2000});
			return;
		}else
		layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>