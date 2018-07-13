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

<title>登录页面</title>

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
<script type="text/javascript" src="static/easyui/jquery.min.js"></script>
<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="static/easyui/locale/easyui-lang-zh_CN.js"></script>

</head>

<body>
	<div id="loginDlg">
		<form id="loginForm">
			<table cellpadding="6">
				<!-- 第一行：项目图片处 -->
				<tr>
					<td colspan="2"><img src="static/images/logo.png" width="260px"></img></td>
				</tr>

				<!-- 第三行：姓名行 -->
				<tr>
					<td id="logNameType">姓&nbsp;&nbsp;名:</td>
					<td><input type="text" name="username"></input></td>
				</tr>
				<!-- 第四行：密码行 -->
				<tr>
					<td>密&nbsp;&nbsp;码:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				
				<!-- 第五行：验证码输入行 -->
				<tr>
					<td>验证码:</td>
					<td>
						<input type="text" id="j-captcha" name="captchaValue" placeholder="验证码"><br/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><img id="captchaImg" alt="点击更换" title="点击更换" onclick="changeVerifyCode(this)" src="Kaptcha"></td>
				</tr>
			</table>
		</form>
		<!-- 登录按钮 -->
		<div id="loginBtnDiv">
			<input type="button" id="loginBtn" onclick="submitForm()" value="登录"/>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#loginDlg").dialog({
			title : "用户登录",
			width : 450,
			height : 390,
			closable : false,
			draggable : false
		});

		//校验文本框和密码框
		$("input[type='text'], input[type='password']").textbox({
			required : true,
		});

		//登录按钮
		$("#loginBtn").linkbutton({
			width : 240,
			height: 40
		});
		
		//登录表单
		$("#loginForm").form({
			url:"login/goLogin",
			success:function(data){	
				if(data == "0"){
					location.href = "login/toIndex";
				}else if(data == "1"){
					$.messager.show({
						title : "登录的消息",
						msg : "用户名或密码错误，请重新登录",
						timeout : 3000,
						showType : "slide"
					});
				}else{
					$.messager.show({
						title : "登录的消息",
						msg : "验证码输入错误",
						timeout : 3000,
						showType : "slide"
					});
				
					//刷新验证码
					$("#captchaImg").attr("src","Kaptcha");
				}
			}
		});
	});
	
	function submitForm(){
		$("#loginForm").submit();
	}

	//回车触摸发登录
	document.onkeydown = function(e) {
		var e = window.event ? window.event : e;
		if (e.keyCode == 13) {
			submitForm();
		}
	}
	
	function changeVerifyCode(img){
		img.src = "Kaptcha";
	}
</script>
</html>
