<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, com.bao.domain.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form method="post" action="StudentSearchServlet" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 搜索数据</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" > 搜索内容</a> </li>
        <li>搜索：</li>
        
			<if condition="$iscid eq 1">
			  <li>
				<select name="option" class="input" style="width:200px; line-height:17px;" >
				  <option value="">请选择搜索分类</option>
				  <option value="sid">按学号查找</option>
				  <option value="sname">按姓名查找</option>
				  <option value="myclass">按班级查找</option>
				  <option value="score">按分数查找</option>
				</select>
			  </li>
			</if>
			<li>
			  <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
			  <input type="submit" class="button border-main icon-search" value="搜索">
			</li>
      </ul>
    </div>
  </div>
</form>

<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 查询结果</strong></div>
  
    <table class="table table-hover text-center">
		     
		  <!-- 直接通过jstl标签从请求对象中获取学生分页列表对象 -->
		  <c:if test="${stuList == null}">
			<div class="panel-head"><strong class="icon-reorder"> <font color = "#FF0000" >没有符合搜索条件的学生信息,您输入的查询条件有误,请重新输入!</font></strong></div>
		  </c:if>
		  
		  <c:if test="${stuList != null}">
		   <tr>
			<th width="120">学号</th>
			<th>姓名</th>       
			<th>班级</th>
			<th>成绩</th>
			<th>操作</th>       
		  </tr>  
			<c:forEach items="${stuList}" var="stu">
				<tr>
				<td><input type="checkbox" name="id[]" value="1" />${stu.id }</td>
				<td align="center">${stu.name }</td>
				<td align="center">${stu.myclass }</td>
				<td align="center">${stu.score }</td>
				<td>	
					<div class="button-group">
						<a type="button" class="button border-main" href="admin/modify.jsp?id=${stu.id }"><span class="icon-edit"></span>修改</a>
						<a class="button border-red" href="StudentDeleteServlet?id=${stu.id }" onClick="return confirm('真的要删除该学生吗?')"><span class="icon-trash-o"></span> 删除</a>
					</div>
				</td>
				</tr>	
			</c:forEach>
		  </c:if>
		
        
    </table>
  </div>
</form>

</body>
</html>