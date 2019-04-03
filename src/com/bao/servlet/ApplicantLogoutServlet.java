package com.bao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 系统退出功能请求Servlet
 */
@WebServlet("/ApplicantLogoutServlet")
public class ApplicantLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplicantLogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获得用户会话，使其失效
		HttpSession session = request.getSession();
		session = null;//清空
		request.getSession().invalidate();//销毁
		// 请求重定向到网站首页
		response.sendRedirect("login.html");
	}

}
