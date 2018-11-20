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
                        <i class="fa fa-user fa-fw"></i><font color="#000000"> 欢迎登录</font><i class="fa fa-caret-down"></i>
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
                        <a href="${domain}/userAdmin/main.action" ><i class="fa fa-qrcode"></i> 个人信息</a>
                    </li>
                    <li>
                        <a href="#"  class="active-menu"><i class="fa fa-sitemap"></i> 服务管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="${domain}/userAdmin/device.action"  class="active-menu">设备信息</a>
                            </li>
                            <li>
                                <a href="${domain}/userAdmin/nurse.action">护理信息</a>
                            </li>
						</ul>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                            	欢迎使用凯达敬老院后台管理系统
                        </h1> 
                                                
                         <div style="padding: 20px">
 						  <form>
							   <div class="form-group">
							    <label for="exampleInputEmail1">设备名称：${name }</label>
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">使用情况：${state }</label>
							  </div>
							   <div class="form-group">
							    <label for="exampleInputEmail1">使用时间：${create_time }</label>
							  </div>
						</form>
					</div>
		</div>
		
            <div id="page-inner"> 
               
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
    <script src="${domain}/js/custom.js"></script>

</body>
</html>