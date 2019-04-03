package com.bao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bao.dao.ApplicantDAO;
import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.Student;

/**
 * 修改的servlet
 */
@WebServlet("/StudentModifyServlet")
public class StudentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public StudentModifyServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求参数的字符编码
		request.setCharacterEncoding("utf-8");

		// 获得请求参数
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);

		String name = request.getParameter("name");
		String myclass = request.getParameter("myclass");

		String sScore = request.getParameter("score");
		double score = Double.parseDouble(sScore);

		// 把表单参数封装到实体对象中
		Student s = new Student(id, name, myclass, score);

		// 借助Dao修改相应的记录
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		int flag = stuDao.modify(s);

		// 4.生成响应结果页面
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.print("<script type='text/javascript'>");
		out.print("alert('修改成功，将跳转到学生列表页面！');");
		out.print("parent.location.reload();");
		out.print("</script>");
	}

}
