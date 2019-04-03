<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.bao.domain.Student,com.bao.dao.IStudentDao,
			com.bao.dao.impl.StudentDaoJdbcImpl"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>

<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 添加信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="StudentAddServlet">
           
      <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="name" size="50" placeholder="请输入姓名" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">班级：</label>
        </div>
        <div class="field">
          
		  <select name="myclass" class="input w50" >
				  <option value="">请输入班级</option>
				  <option value="13专1">13专1</option>
				  <option value="13专2">13专2</option>
				  <option value="14专1">14专1</option>
				  <option value="14专2">14专2</option>
				  <option value="15专1">15专1</option>
				  <option value="15专2">15专2</option>
				  <option value="16专1">16专1</option>
				  <option value="16专2">16专2</option>
		  </select>		  
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">成绩：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="score" size="50" placeholder="请输入成绩" />          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body></html>