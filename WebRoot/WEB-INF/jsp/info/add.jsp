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
							    <input type="text" class="form-control" id="userId" placeholder="老人id">
							  </div>
							  <!--  <div class="form-group">
							    <label for="exampleInputEmail1">床位ID</label>
							    <input type="text" class="form-control" id="bedId" placeholder="床位ID">
							  </div> -->
							  <div class="form-group">
							    <label for="exampleInputEmail1">缴费情况</label>
							    <select class="form-control" id="state" name="state">
								<option value="">--是否已缴费--</option> 
								<option value="0" selected="selected">未缴</option>
								<option value="1">已缴</option>
								</select>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">缴费金额</label>
							    <input type="text" class="form-control" id="amount" placeholder="缴费金额">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">入院时间</label>
							    <input type="text" class="form-control" id="datetimepicker">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">出院时间</label>
							    <input type="text" class="form-control" id="datetimepicker2">
							  </div>
							  <div align="center"><button type="button" class="btn btn-primary" onclick="sub()">提交</button></div>
						</form>
					</div>
  </body>
<script type="text/javascript">
$('#datetimepicker').datetimepicker({
    format: 'yyyy-mm-dd hh:ii:ss'
});
$('#datetimepicker2').datetimepicker({
    format: 'yyyy-mm-dd hh:ii:ss'
});

function sub(){
var userId=$("#userId").val();
var state=$("#state").val();
var amount=$("#amount").val();
var datetimepicker=$("#datetimepicker").val();
var datetimepicker2=$("#datetimepicker2").val();
	$.post("${domain}/info/add.action", {
		userId : userId,
		state : state,
		'amount' : amount,
		'exit_time' : datetimepicker2,
		'create_time' : datetimepicker
		},  function(result) {
		if(result == 'false'){
			layer.msg('老人编号输入有误，请重新输入!',{icon:2,time:2000});
			return;
		}else if(result == 'error'){
			layer.msg('床位编号输入有误，请重新输入!',{icon:2,time:2000});
			return;
		}else
			layer.msg('添加成功!',{icon:1,time:2000});
	});
}
</script>
</html>