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
    
    <title>结算</title>
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
							    <label for="exampleInputEmail1">老人id：${id }</label>
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">姓名：${name }</label>
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">床位ID：${bedId }</label>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">入院时间：${create_time }</label>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">出院时间：${exit_time }</label>
							  </div>
							  <div class="form-group">
							    <label for="exampleInputEmail1">共计 <b>${num }</b> 天，每天床位价格为<font style="color: red">${price }</font>元，消费总金额<font style="color: red">${amount }</font>元</label>
							  </div>
						</form>
					</div>
  </body>
</html>