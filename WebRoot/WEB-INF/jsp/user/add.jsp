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
    
    <title>添加用户</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							   <div class="form-group">
							    <label for="exampleInputEmail1">姓名</label>
							    <input type="text" class="form-control" id="name" placeholder="姓名">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">年龄</label>
							    <input type="text" class="form-control" id="age" placeholder="年龄">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">性别</label>
							    <select class="form-control" id="sex" name="sex">
								<option value="">--性别--</option> 
								<option value="0">女</option>
								<option value="1">男</option>
								</select>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">床号</label>
							    <input type="text" class="form-control" id="bedId" placeholder="床号">
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">
function sub(){
var id=$("#id").val();
var name=$("#name").val();
var sex=$("#sex").val();
var age=$("#age").val();
var bedId=$("#bedId").val();
	$.post("${domain}/user/add.action", {
		id : id,
		'name' : name,
		sex : sex,
		age : age,
		bedId : bedId
		},  function(result) {
		layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>