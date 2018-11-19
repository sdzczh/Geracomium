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
							    <label for="exampleInputEmail1">仓库id</label><input type="hidden" value="${data.id}" id="id">
							    <input type="text" class="form-control" id="rid" placeholder="仓库id" value="${data.rid }">
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">管理员id</label>
							    <input type="text" class="form-control" id="sid" placeholder="管理员ID" value="${data.sid }">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">出/入库</label>
							    <select class="form-control" id="type" name="type">
								<option value="0" <c:if test="${data.type=='0'}">selected="selected"</c:if>>入库</option>
								<option value="1" <c:if test="${data.type=='1'}">selected="selected"</c:if>>出库</option>
								</select>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">时间</label>
							    <input type="text" class="form-control" id="datetimepicker" value="${data.create_time }">
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">
$('#datetimepicker').datetimepicker({
    format: 'yyyy-mm-dd hh:ii:ss'
});

function sub(){
var id=$("#id").val();
var rid=$("#rid").val();
var sid=$("#sid").val();
var type=$("#type").val();
var datetimepicker=$("#datetimepicker").val();
	$.post("${domain}/operReper/update.action", {
		id : id,
		rid : rid,
		sid : sid,
		type : type,
		'create_time' : datetimepicker
		},  function(result) {
		if(result == 'false'){
			layer.msg('仓库编号输入有误，请重新输入!',{icon:2,time:2000});
			return;
		}else if(result == 'error'){
			layer.msg('管理员编号输入有误，请重新输入!',{icon:2,time:2000});
			return;
		}else
			layer.msg('修改成功!',{icon:1,time:2000});
	});
}
</script>
</html>