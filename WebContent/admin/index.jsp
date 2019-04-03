<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>学生信息系统</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />
			
				${sessionScope.SESSION_USERNAME}
				
	</h1>
  </div>
  <div class="head-l"><a class="button button-little bg-green" href="register.html" target="_blank"><span class="icon-home"></span>注册账号</a>&nbsp;&nbsp;<a class="button button-little bg-red" href="ApplicantLogoutServlet"><span class="icon-power-off"></span>退出登录</a> </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>信息管理</h2>
  <ul style="display:block">
    <li><a href="StudentListServlet" target="right"><span class="icon-caret-right"></span>查看列表</a></li>
    <li><a href="admin/add.jsp" target="right"><span class="icon-caret-right"></span>添加数据</a></li>
    <li><a href="admin/search.jsp" target="right"><span class="icon-caret-right"></span>搜索数据</a></li>
  </ul>   
  <h2><span class="icon-pencil-square-o"></span>数据维护</h2>
  <ul>
  	<li><a href="<%=request.getContextPath() %>/ReportServer?reportlet=student.cpt&op=write" target="right"><span class="icon-caret-right"></span>导入数据</a></li>  
    <li><a href="admin/dataxls.html" target="right"><span class="icon-caret-right"></span>导出数据</a></li>   
  </ul>
  <h2><span class="icon-cog"></span>账号设置</h2>
  <ul>
	<li><a href="admin/pass.jsp" target="right"><span class="icon-caret-right"></span>密码修改</a></li>
    <li><a href="ApplicantLogoutServlet"><span class="icon-caret-right"></span>退出账号</a></li>
  </ul>  
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li><a href="{:U('Index/info')}" target="right" class="icon-home"> 首页</a></li>
  <li><a href="##" id="a_leader_txt">网站信息</a></li>
  <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li>
</ul>
<div class="admin">
					
					<iframe scrolling="auto" rameborder="0" src="StudentListServlet" target = "_parent" name="right" width="100%" height="100%"></iframe>
  
</div>
<div style="text-align:center;">
</div>
</body>
</html>