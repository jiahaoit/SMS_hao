package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
 * 添加 学生的servlet
 */
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentAddServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.设置请求参数的编码
		req.setCharacterEncoding("utf-8");
		
		//2.得到请求参数
		String name = req.getParameter("name");
		String myclass = req.getParameter("myclass");
		String sScore = req.getParameter("score");
		
		double score = Double.parseDouble(sScore);
		
		//3.借助dao完成业务逻辑:删除制定学号的学生记录
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		Student student = new Student(name,myclass,score);
		stuDao.add(student);
		
		//4.生成响应结果页面
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.print("<script type='text/javascript'>");
		out.print("alert('添加成功，将跳转到学生列表页面！');");
		out.print("parent.location.reload();");
		out.print("</script>");
	}

}
