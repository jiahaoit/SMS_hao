package com.bao.dao;

import java.util.List;

import com.bao.domain.Student;

/**
 * 定义数据的增删改查的方法 包括查找所有,根据学号查找,根据姓名查找,增加一个学生,修改一个学生,删除一个学生
 * 
 * @author Administrator
 *
 */
public interface IStudentDao {
	public List<Student> findAll();

	public Student findById(int sid);

	public List<Student> findByName(String name);
	
	public List<Student> findByClass(String myclass);
	
	public List<Student> findByScore(int score) ;

	public int add(Student student);

	public int modify(Student student);

	public int delete(int sid);

	// 分页需要的dao操作
	// 1.计算表中记录的总条数
	public int findTotalCount();

	// 2.查询当前页的记录集合
	public List<Student> findOnePage(int pageIndex, int pageSize);
}
