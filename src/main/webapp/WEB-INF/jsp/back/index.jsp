<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" href="static/easyui/themes/default/easyui.css" type="text/css">
	<link rel="stylesheet" href="static/easyui/themes/icon.css" type="text/css">
	<link rel="stylesheet" href="static/css/login.css" type="text/css">
	<script type="text/javascript" src="static/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="static/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="static/easyui/locale/easyui-lang-zh_CN.js"></script>

  </head>
  
<body class="easyui-layout">  
  	<!-- 上部部分north --> 
    <div data-options="region:'north',border:false" style="height:85px;">
		<img style="padding-left: 20px;" height="80px" width="337px"
			class="mainpage_head_img" src="static/images/logo.png"/>
    </div>
    
    <!-- 右边部分east -->
    <div data-options="region:'east',title:'工具箱'" style="width:180px;padding:10px;">
    	<div class="easyui-calendar" style="width:160px;height:160px;"></div> 
    </div>   
    
    <!-- 左边部分west -->  
    <div data-options="region:'west',split:true,title:'导航菜单'" style="width:160px;">
    	<!-- 手风琴  -->
    	<div id="accordion" class="easyui-accordion" data-options="fit:true,border:false">
    	   
		</div>  
    </div>
     
    <!-- 中间主体部分 -->  
    <div id="cc" data-options="region:'center',title:'',
   		<!-- 最大化与缩进 -->
		 tools: [{   
       		iconCls:'icon-full',
      			handler:function(){full()}   
   		},{   
       		iconCls:'icon-unfull',
      			handler:function(){unFull()}   
   		}]">
    	
    	<!-- 主面板 -->
		<div id="back_mainTab" class="easyui-tabs" data-options="fit:true">
		</div>
	</div>
	
	<!-- 下面部分south-->
    <div data-options="region:'south',border:false" style="height:30px;padding:10px;">
		<center>段松松测试项目</center>
	</div> 
	
  </body> 
  
  <script type="text/javascript">
  
  	$(function(){
  		$.ajax({
  			url : "index/listParentMent",
  			type : "post",
  			datatype : "json",
  			success : function(data){
  				$.each(data, function(index, menu){
  					var flag = false;
  					if(index == 0){
  						flag = true;
  					}
  					//加载这个用户可以看到的所有父菜单
  					$("#accordion").accordion("add",{
  						title : menu.mname,
  						content : "<div id="+menu.mname+"></div>",
  						selected : flag
  					});
  					
  					$("#"+menu.mname).tree({
  						url : "index/listSonMent",
  				  		queryParams : {mname : menu.mname},
  				  		onClick : function(node){
  				  			addtabs(node.text, node.url);
  				  		}
  					});
  				});
  			}
  		});
  	});
  	
    // 左边菜单点击事件
  	function addtabs(title, href) {
    	
		var tab = $("#back_mainTab");

		if (tab.tabs("exists", title)) {
			tab.tabs("select", title);
		} else {
			tab.tabs("add", {
				title : title,
				closable : true,
				href : href
			});
		}
	}
  
  </script> 
  
</html>
