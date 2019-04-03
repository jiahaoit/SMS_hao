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
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 查看信息</strong></div>
    
    <table class="table table-hover text-center">
		  <tr>
			<th width="120">学号</th>
			<th>姓名</th>       
			<th>班级</th>
			<th>成绩</th>
			<th>操作</th>       
		  </tr>      
		  <!-- 直接通过jstl标签从请求对象中获取学生分页列表对象 -->
		<c:forEach items="${pageBean.list}" var="stu">
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
        
		  <tr>
			<td colspan="8"><div class="pagelist"> 
				<a href="StudentListServlet?pageIndex=1">首页</a>
				<c:choose>
					<c:when test="${pageBean.pageIndex == 1}">
						<span class="current">${pageBean.pageIndex}</span>
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex+1}">${pageBean.pageIndex+1}</a>
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex+2}">${pageBean.pageIndex+2}</a>
						
						<a href="">...</a>
						<a href="StudentListServlet?pageIndex=${pageBean.pageCount-1}">${pageBean.pageCount-1}</a>
						<a href="StudentListServlet?pageIndex=${pageBean.pageCount}">${pageBean.pageCount}</a>
						
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex + 1}">下一页</a>
					</c:when>

					<c:when test="${pageBean.pageIndex == pageBean.pageCount}">
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex - 1}">上一页</a>
						
						<a href="StudentListServlet?pageIndex=${1}">${1}</a>
						<a href="StudentListServlet?pageIndex=${2}">${2}</a>
						<a href="StudentListServlet?pageIndex=${3}">${3}</a>
						<a href="">...</a>
						
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex - 2}">${pageBean.pageIndex-2}</a>
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex - 1}">${pageBean.pageIndex-1}</a>
						<span class="current">${pageBean.pageIndex}</span>
					</c:when>
					
					<c:otherwise>
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex - 1}">上一页</a>
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex - 1}">${pageBean.pageIndex-1}</a>
						<span class="current">${pageBean.pageIndex}</span>
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex + 1}">${pageBean.pageIndex+1}</a>
						<a href="">...</a>
						<a href="StudentListServlet?pageIndex=${pageBean.pageCount-1}">${pageBean.pageCount-1}</a>
						<a href="StudentListServlet?pageIndex=${pageBean.pageCount}">${pageBean.pageCount}</a>
						
						<a href="StudentListServlet?pageIndex=${pageBean.pageIndex + 1}">下一页</a>
					</c:otherwise>
				</c:choose>
				<a href="StudentListServlet?pageIndex=${pageBean.pageCount}">尾页</a>
				<a href="StudentListServlet?pageIndex=${pageBean.pageCount}">共${pageBean.pageCount}页</a>
				<a href="StudentListServlet?pageIndex=${pageBean.pageCount}">当前页：${pageBean.pageIndex}</a>
			</div></td>
		  </tr>
    </table>
  </div>
</form>

</body></html>