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
							    <label for="exampleInputEmail1">老人姓名</label><input type="hidden" value="${data.id}" id="id">
							    <input type="text" class="form-control" id="name" value="${name}" readonly="readonly">
							  </div>
							  <%-- <div class="form-group">
							    <label for="exampleInputEmail1">床位号</label><input type="hidden" value="${data.userId}" id="userId">
							    <input type="text" class="form-control" id="bedId" placeholder="床位号" value="${data.bedId}">
							  </div> --%>
							  <div class="form-group"><input type="hidden" value="${data.userId}" id="userId">
							    <label for="exampleInputEmail1">缴费情况</label><input type="hidden" value="${data.bedId}" id="bedId">
							    <select class="form-control" id="state" name="state">
								<option value="">--是否已缴费--</option> 
								<option value="0" <c:if test="${data.state=='0'}">selected="selected"</c:if>>未缴</option>
								<option value="1" <c:if test="${data.state=='1'}">selected="selected"</c:if>>已缴</option>
								</select>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">缴费金额</label>
							    <input type="text" class="form-control" id="amount" placeholder="缴费金额" value="${data.amount}">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">入院时间</label>
							    <input type="text" class="form-control" value="${data.create_time }" id="datetimepicker">
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">出院时间</label>
							    <input type="text" class="form-control" value="${data.exit_time }" id="datetimepicker2">
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
var id=$("#id").val();
var userId=$("#userId").val();
var bedId=$("#bedId").val();
var amount=$("#amount").val();
var state=$("#state").val();
var create_time=$("#datetimepicker").val();
var exit_time=$("#datetimepicker2").val();
var content=$("#content").val();
	$.post("${domain}/info/update.action", {
		id : id,
		bedId : bedId,
		userId : userId,
		'amount' : amount,
		state : state,
		'exit_time' : exit_time,
		'create_time' : create_time
		},  function(result) {
		layer.msg('修改成功!',{icon:1,time:2000});
	});
}
</script>
</html>