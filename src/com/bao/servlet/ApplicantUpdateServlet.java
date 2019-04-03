package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * 修改密码功能实现
 * 根据账号,修改密码
 */
@WebServlet("/ApplicantUpdateServlet")
public class ApplicantUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ApplicantUpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求和响应编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		// 登录验证
		ApplicantDAO dao = new ApplicantDAO();
		String password = dao.isUpdate(username);
		if (password.equals(oldpassword)) {//比较密码是否正确
			// 将session更新
			HttpSession session = request.getSession();
			session.setAttribute("SESSION_USERNAME", username);
			dao.SaveUpdate(username,newpassword);//修改密码
			out.print("<script type='text/javascript'>");
			out.print("alert('修改密码成功！');");
			out.print("parent.location.reload();");
			out.print("</script>");
		} else {// 错误提示login.html
			out.print("<script type='text/javascript'>");
			out.print("alert('原始密码错误，请重新输入！');");
			out.print("window.location='admin/pass.jsp';");
			out.print("</script>");
		}
	}


}
