package com.bao.test;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.bao.dao.ApplicantDAO;
import com.bao.dao.IStudentDao;
import com.bao.dao.impl.StudentDaoJdbcImpl;
import com.bao.domain.Student;

public class Test {

	public static void main(String[] args) {
		String myclass = "уе";
		IStudentDao stuDao = new StudentDaoJdbcImpl();
		List<Student> stuList = stuDao.findByScore(60);
		System.out.println(stuList);
	}

}
