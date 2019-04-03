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
import javax.servlet.http.HttpSession;

import com.bao.dao.ApplicantDAO;
import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.Student;

/**
 * 登录功能实现
 */
@WebServlet("/ApplicantLoginServlet")
public class ApplicantLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicantLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verifyCode");
		// 判断验证码是否正确
		String sessionValidateCode = (String) request.getSession().getAttribute("SESSION_VALIDATECODE");
		if (!sessionValidateCode.equals(verifyCode)) {
			out.print("<script type='text/javascript'>");
			out.print("alert('请正确输入验证码！');");
			out.print("window.location='login.html';");
			out.print("</script>");
		}
		// 登录验证
		ApplicantDAO dao = new ApplicantDAO();
		String loginUsername = dao.login(username, password);
		if (loginUsername != null) {// 若传回的账号不为空,则登录成功,将查询到的学生信息存入请求对象,跳转到学生列表页面
			IStudentDao stuDao = new StudentDaoJdbcImpl();
			List<Student> stuList = stuDao.findAll();

			// 将用户名存入session用于头部文件显示用户名
			HttpSession session = request.getSession();
			session.setAttribute("SESSION_USERNAME", username);
			// 将查询到的学生信息存入请求对象,跳转到首页
			//request.getRequestDispatcher("admin/index.jsp").forward(request, response);
			response.sendRedirect("admin/index.jsp");
		} else {// 错误提示login.html
			out.print("<script type='text/javascript'>");
			out.print("alert('用户名或密码错误，请重新输入！');");
			out.print("window.location='login.html';");
			out.print("</script>");
		}
	}

}
