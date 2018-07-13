<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="static/easyui/themes/default/easyui.css"
	type="text/css">
<link rel="stylesheet" href="static/easyui/themes/icon.css"
	type="text/css">
<link rel="stylesheet" href="static/css/login.css" type="text/css">

</head>

<body>
	<table id="userlist">

	</table>
	<script type="text/javascript">
		$(function() {
			$("#userlist").datagrid({
	  			url : "user/listUserInfo",
	  			title : "用户信息",
	  			ctrlSelect : true, 	// 可以允许使用Ctrl键+鼠标点击的方式进行多选操作
	  			pagination : true,
	  			pageSize : 2,
	  			pageList : [2, 5, 10, 15],
	  			columns : [ [ {
	  				field : "", 	// field属性, 通过远程地址取数据, 需要field的名字, 与传过来的json对象属性名一致
	  				title : "序号",
	  				width : 80,
	  				halign : "center",
	  				align : "center",
	  				sortable : true,
	  				fixed : false,
	  				resizable : false,
	  				checkbox : true
	  			}, {
	  				field : "userid",
	  				title : "编号",
	  				width : 150,
	  				halign : "center",
	  				align : "center",
	  				sortable : true,
	  				fixed : false,
	  				resizable : false
	  			},{
	  				field : "username",
	  				title : "姓名",
	  				width : 150,
	  				halign : "center",
	  				align : "center",
	  				sortable : true,
	  				fixed : false,
	  				resizable : false
	  			}, {
	  				field : "password",
	  				title : "密码",
	  				width : 160,
	  				halign : "center",
	  				align : "center",
	  				fixed : false,
	  				resizable : false,
	  			},] ],
	  		});
		});
	</script>
</body>
<script type="text/javascript" src="static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>

</html>
