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
    
    <title>完善用户资料</title>
	<link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
	<script src="${domain}/js/jquery.min.js"></script>
	<script src="${domain}/js/layer.js"></script>
  </head>
  
  <body>		
 					  <div style="padding: 20px">
 						  <form>
							  <div class="form-group">
							    <label for="exampleInputEmail1">姓名</label><input type="hidden" value="${data.id}" id="id">
							    <input type="text" class="form-control" id="name" placeholder="帐号" value="${data.name}">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">年龄</label><input type="hidden" value="${data.create_time}" id="create_time">
							    <input type="text" class="form-control" id="age" placeholder="年龄" value="${data.age}">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">性别</label>
							    <select class="form-control" id="sex" name="sex">
								<option value="">--性别--</option> 
								<option value="0" <c:if test="${data.sex=='0'}">selected="selected"</c:if>>女</option>
								<option value="1" <c:if test="${data.sex=='1'}">selected="selected"</c:if>>男</option>
								</select>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">床号</label>
							    <input type="text" class="form-control" id="bedId" placeholder="床号" value="${data.bedId}">
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
var create_time=$("#create_time").val();
	$.post("${domain}/user/update.action", {
		id : id,
		'name' : name,
		sex : sex,
		age : age,
		bedId : bedId,
		'create_time' : create_time
		},  function(result) {
		layer.msg('修改成功!',{icon:1,time:2000});
	});
}
</script>
</html>