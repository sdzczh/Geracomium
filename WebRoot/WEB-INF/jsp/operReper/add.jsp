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
							    <label for="exampleInputEmail1">仓库id</label>
							    <input type="text" class="form-control" id="rid" placeholder="仓库id">
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">管理员id</label>
							    <input type="text" class="form-control" id="sid" placeholder="管理员ID">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">出/入库</label>
							    <select class="form-control" id="type" name="type">
								<option value="0" selected="selected">入库</option>
								<option value="1">出库</option>
								</select>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">时间</label>
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
var rid=$("#rid").val();
var sid=$("#sid").val();
var type=$("#type").val();
var datetimepicker=$("#datetimepicker").val();
	$.post("${domain}/operReper/add.action", {
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
			layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>