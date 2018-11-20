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
							    <label for="exampleInputEmail1">手机号</label>
							    <input type="text" class="form-control" id="phone" placeholder="手机号">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">咨询内容</label>
							    <textarea id="content" class="form-control"></textarea>
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">
function sub(){
var id=$("#id").val();
var phone=$("#phone").val();
var name=$("#name").val();
var content=$("#content").val();
	$.post("${domain}/consult/add.action", {
		id : id,
		'phone' : phone,
		'name' : name,
		'content' : content,
		},  function(result) {
		layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>