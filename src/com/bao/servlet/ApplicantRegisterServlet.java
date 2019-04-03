package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.ApplicantDAO;
import com.bao.domain.Student;
import com.bao.utils.JDBCUtils;

/**
 * 注册功能实现 调用dao对邮箱唯一性验证,并保存用户信息
 */
@WebServlet("/ApplicantRegisterServlet")
public class ApplicantRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicantRegisterServlet() {
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
			out.print("window.location='register.html';");
			out.print("</script>");
		} else {
			// 判断邮箱是否已被注册
			ApplicantDAO dao = new ApplicantDAO();
			boolean flag = dao.isExistUsername(username);
			if (flag) {// 为true,有此邮箱
				// 邮箱已注册,进行错误提示
				out.print("<script type='text/javascript'>");
				out.print("alert('账号已被注册，请重新输入！');");
				out.print("window.location='register.html';");// 被注册则重新加载本页面
				out.print("</script>");
			} else {
				// 邮箱未被注册，保存注册用户信息
				dao.save(username, password);
				// 注册成功，重定向到登录页面
				//response.sendRedirect("login.html");
				out.print("<script type='text/javascript'>");
				out.print("alert('注册成功，即将跳转到登录界面！');");
				out.print("window.location='login.html';");
				out.print("</script>");
			}
		}
	}

}
