<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户登录</title>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/layer.js"></script>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet"> 
</head>
<body>

<div class="container">
	<section id="content">
		<form action="">
			<h1>用户登录</h1>
			<div>
				<input type="text" placeholder="账号" required="" id="id" />
			</div>
			<div>
				<input type="password" placeholder="密码" required="" id="password" />
			</div>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div> 
			<div>
				<center>
				<input type="button" onclick="login()" value="登录" class="btn btn-primary" id="js-btn-login" style="width: 40%;margin-left: 30%">
				</center>
				<a href="${pageContext.request.contextPath}/admin/exit.action">管理员登录</a>
				<!-- <a href="#">Register</a> -->
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div>


<script type="text/javascript">
function login(){
	var id = $("#id").val();
	var password = $("#password").val();
	$.post("${pageContext.request.contextPath}/userAdmin/login.action",{id : id, 'password' : password},function(result){
		if(result == 'false'){
			layer.msg('账号或密码错误');
			window.setTimeout("window.location.reload();",1000);
		}
		if(result == 'true'){
			window.location.href = "${pageContext.request.contextPath}/userAdmin/main.action";
		}
	})
}
</script>
</body>
</html>