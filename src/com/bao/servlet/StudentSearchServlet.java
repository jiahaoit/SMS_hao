package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据条件搜索学生的servlet
 */
@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentSearchServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 1.设置请求参数的编码
		req.setCharacterEncoding("utf-8");

		// 2.得到请求参数
		String option = req.getParameter("option");// 下拉列表select的选择参数
		String keywords = req.getParameter("keywords");// 搜索框的参数

		// 3.借助dao完成业务逻辑:删除制定学号的学生记录
		IStudentDao stuDao = new StudentDaoJdbcImpl();

		// 逻辑判断
		if ("sid".equals(option)) {// 是学号搜索
			int id = Integer.parseInt(keywords);
			Student student = stuDao.findById(id);
			List<Student> stuList = new ArrayList<Student>();// 用array实例化
			stuList.add(student);
			if (student == null) {
				stuList = null;
			}
			req.setAttribute("stuList", stuList);
		}
		if ("sname".equals(option)) {// 是姓名搜索
			List<Student> stuList = stuDao.findByName(keywords);
			req.setAttribute("stuList", stuList);
		}
		if ("myclass".equals(option)) {// 是班级搜索
			List<Student> stuList = stuDao.findByClass(keywords);
			req.setAttribute("stuList", stuList);
		}
		if ("score".equals(option)) {// 是分数搜索
			int score = Integer.parseInt(keywords);
			List<Student> stuList = stuDao.findByScore(score);
			req.setAttribute("stuList", stuList);
		}
		// 5.把查询对象存储到request作用域，然后跳转到相应的页面
		req.getRequestDispatcher("admin/search.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
