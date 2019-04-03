package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.*;

import com.bao.domain.Student;

import sun.awt.image.ImageWatched.Link;

@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private int pageSize = 5;//直接设定好一页显示的行数为5行
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 实现分页显示
		// 1. 设置请求参数的编码
		request.setCharacterEncoding("utf-8");

		// 2. 获得页面的请求参数 :要显示的页号pageIndex
		String sPageIndex = request.getParameter("pageIndex");
		if (sPageIndex == null || sPageIndex == "")//是第一次请求,则将本页置为1
			sPageIndex = "1";
		int pageIndex = Integer.parseInt(sPageIndex);

		// 3. 借助Dao查询出分页需要的参数
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		int totalCount = stuDao.findTotalCount();//取得总页数
		List<Student> stuList = stuDao.findOnePage(pageIndex, pageSize);//根据当前页数和每页显示的行数取得已经分页的学生列表

		// 4.根据上面的参数,创建分页对象,便于存储到request对象中,被stu_list.jsp获得
		StudentPageBean<Student> pageBean = new StudentPageBean<Student>(pageIndex, pageSize, totalCount, stuList);
		pageBean.init();//初始化,得到各项参数,便于实现上一页下一页的功能

		// 5.把分页对象存储到request作用域，然后跳转到相应的book.jsp页面
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("admin/list.jsp").forward(request,response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
