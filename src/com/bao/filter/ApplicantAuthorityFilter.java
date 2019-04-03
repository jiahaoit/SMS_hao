package com.bao.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * /applicant/*--对此目录下所有文件请求过滤
 */
@WebFilter(urlPatterns = { "/admin/*" }, 
servletNames = {
"com.bao.servlet.ApplicantUpdateServlet", 
"com.bao.servlet.StudentAddServlet", 
"com.bao.servlet.StudentDeleteServlet", 
"com.bao.servlet.StudentModifyServlet", 
"com.bao.servlet.StudentSearchServlet", 
"com.bao.servlet.StudentListServlet" }, //所过滤的servlet
initParams = { @WebInitParam(name = "loginPage", value = "login.html") }, //初始参数
dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD })//对 直接请求 和 转发  两种模式 过滤
public class ApplicantAuthorityFilter implements Filter {
	private String loginPage = "login.html";
    public ApplicantAuthorityFilter() {
    }

	public void destroy() {
		this.loginPage = null;//filter销毁时置空
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// 判断被拦截的请求用户是否处于登录状态
		if (session.getAttribute("SESSION_USERNAME") == null) {//未登录则转发到登录界面
			// 获取被拦截的请求地址及参数
			String requestPath = req.getRequestURI();//请求地址
			if (req.getQueryString() != null) {
				requestPath += "?" + req.getQueryString();//请求参数
			}
			// 将请求地址保存到request对象中转发到登录页面
			req.setAttribute("requestPath", requestPath);
			//request.getRequestDispatcher(loginPage)
					//.forward(request, response);
			resp.sendRedirect("../login.html");
			return;
		} else {
			chain.doFilter(request, response);//登录则放行,给予目标资源
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
				// 获取当请求被拦截时转向的页面
				loginPage = fConfig.getInitParameter("loginPage");
				if (null == loginPage) {
					loginPage = "/login.html";
				}
	}

}
