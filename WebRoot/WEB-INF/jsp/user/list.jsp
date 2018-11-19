<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <c:set var="domain" value="${pageContext.request.contextPath}"></c:set>
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title>Bootstrap Admin html Template</title>
    <link rel="stylesheet" type="text/css" href="${domain}/css/bootstrap.css">
    <link href="${domain}/css/font-awesome.css" rel="stylesheet" />
   
   <link href="${domain}/css/custom-styles.css" rel="stylesheet" />
   <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
   <link href="${domain}/css/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${domain}/admin/getUserList.action"><strong>凯达敬老院后台管理</strong></a>
				<div id="sideNav" href="">
		<a href="${domain}/user/index.action"><i class="fa fa-bars icon">Back</i> </a>
		</div>
            </div>
            <ul class="nav navbar-top-links navbar-right">
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i><font color="#000000"> 欢迎&nbsp;&nbsp; <b>${admin.account}</b> &nbsp;&nbsp;登录&nbsp;&nbsp;</font><i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li class="divider"></li>
                        <li><a href="${domain}/admin/exit.action"><i class="fa fa-sign-out fa-fw"></i> 退出</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    
                    <li>
                        <a href="${domain}/admin/getUserList.action"  class="active-menu"><i class="fa fa-qrcode"></i> 用户管理</a>
                    </li>
                    <li>
                        <a href="${domain}/admin/getFoodList.action" ><i class="fa fa-qrcode"></i> 菜品管理</a>
                    </li>
                    <li>
                        <a href="${domain}/admin/getOrderList.action"><i class="fa fa-qrcode"></i> 订单管理</a>
                    </li>
                    
                    
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                            	用户管理	 <small>显示所有老人信息</small>
                        </h1> 
						<ol class="breadcrumb">
					  <li><a style="text-decoration:none" onClick="add()" href="javascript:;" class='btn btn-danger' title="添加用户">添加用户</a></li>
					</ol> 
									
		</div>
		
            <div id="page-inner"> 
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             所有用户信息
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive"> 
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example" data-toggle="table" >
                                    <thead>
                                        <tr>
                                            <th>老人编号</th>
                                            <th>姓名</th>
                                            <th>年龄</th>
                                            <th>性别</th>
                                            <th>床位号</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="list" items="${data}">
                                        <tr class="odd gradeX">
                                            <td>${list.id }</td>
                                            <td>${list.name }</td>
                                            <td>${list.age }</td>
                                            <td>
                                            	<c:if test="${list.sex==0}">女</c:if>
                                            	<c:if test="${list.sex==1}">男</c:if>
                                            </td>
                                            <td>${list.bedId }</td>
                                            <td align="center">
        <a style="text-decoration:none" onclick="edit(${list.id})" class='btn btn-default' title="编辑">编辑</a>
		<a style="text-decoration:none" onClick="del(${list.id})" href="javascript:;" class='btn btn-danger' title="删除">删除</a>
											</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
        </div>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
    <script src="${domain}/js/jquery.min.js"></script>
    <script src="${domain}/js/bootstrap.js"></script>
    <script src="${domain}/js/jquery.metisMenu.js"></script>
    <script src="${domain}/js/jquery.dataTables.js"></script>
    <script src="${domain}/js/dataTables.bootstrap.js"></script>
    <script src="${domain}/js/bootstrap-table.js"></script>
    <script src="${domain}/js/layer.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
	<script type="text/javascript">
	function del(id){
			layer.confirm('确认要删除该用户吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${domain}/user/del.action',
			data: {id : id},
			success: function(data){
				layer.msg('该用户已删除!',{icon: 1,time:2000});
				setTimeout(function(){
					window.location.reload();
				},2000)
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
	}
	function edit(id,uname,pwd){
		parent.layer.open({
		    type: 2,
		    shadeClose: true,
		    shade: 0.8,
		    area: ['580px', '50%'],
		    content: '${domain}/user/toUpdate.action?&id='+id,
		    end: function () {
		       location.reload();
		    }
		});
	}
	function add(){
		parent.layer.open({
		    type: 2,
		    shadeClose: true,
		    shade: 0.8,
		    area: ['580px', '50%'],
		    content: '${domain}/user/toAdd.action',
		    end: function () {
		       location.reload();
		    }
		});
	}
	</script>    
   
</body>
</html>