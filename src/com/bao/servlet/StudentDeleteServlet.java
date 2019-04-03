package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除一个学生的servlet
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentDeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1.设置请求参数的编码
		req.setCharacterEncoding("utf-8");
		
		//2.得到请求参数
		String sId = req.getParameter("id");
		int id = Integer.parseInt(sId);
		
		//3.借助dao完成业务逻辑:删除制定学号的学生记录
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		stuDao.delete(id);
		
		//4.生成响应结果页面
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print("<script type='text/javascript'>");
		out.print("alert('删除成功，将跳转到学生列表页面！');");
		out.print("parent.location.reload();");
		out.print("</script>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
