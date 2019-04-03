package com.bao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bao.dao.IStudentDao;
import com.bao.domain.Student;
import com.bao.utils.JDBCUtils;

/**
 * 实现接口的增删改查的方法 包括查找所有,根据学号查找,根据姓名查找,增加一个学生,修改一个学生,删除一个学生
 * 
 */
public class StudentDaoJdbcImpl implements IStudentDao {

	/**
	 * 查询所有学生
	 */
	public List<Student> findAll() {
		Connection conn = null;// 链接数据库
		PreparedStatement ps = null;// 预编译
		ResultSet rs = null;// 结果集--
		List<Student> allStu = null;// 储存获得的结果到列表中

		try {
			conn = JDBCUtils.getConnection();// 获得数据库链接
			String sql = "select * from t_student";// SQL语句
			ps = conn.prepareStatement(sql);// 用SQL语句实例化prepareStatement
			rs = ps.executeQuery();// 执行查询并获得结果集

			while (rs.next()) {// 如果结果不为空
				if (allStu == null) {// 只需要第一次实例化,
					allStu = new ArrayList<Student>();// 用array实例化
				}

				Student s = new Student();// new一个student实体类用于接收结果集
				s.setId(rs.getInt("id"));// 取得id并写入student实体类
				s.setName(rs.getString("name"));// 取得name并写入student实体类
				s.setMyclass(rs.getString("myclass"));// 取得myclass并写入student实体类
				s.setScore(rs.getDouble("score"));// 取得socre并写入student实体类

				allStu.add(s);// 依次添加到集合中
			}
		} catch (SQLException e) {
			System.err.println("查询所有学生失败,请查看具体原因!");
			e.printStackTrace();
		}
		return allStu;
	}

	/**
	 * 根据班级查询,返回一个学生列表
	 */
	public List<Student> findByClass(String myclass) {
		Connection conn = null;// 链接数据库
		PreparedStatement ps = null;// 预编译
		ResultSet rs = null;// 结果集--
		List<Student> allStu = null;// 储存获得的结果到列表中

		try {
			conn = JDBCUtils.getConnection();// 获得数据库链接
			String sql = "select * from t_student where myclass like ";// SQL语句
			sql = sql + "'%"+myclass+"%'";//支持了模糊查询
			ps = conn.prepareStatement(sql);// 用SQL语句实例化prepareStatement
			//ps.setString(1, "'%"+myclass+"%'");// 传入的myclass
			rs = ps.executeQuery();// 执行查询并获得结果集

			while (rs.next()) {// 如果结果不为空
				if (allStu == null) {// 只需要第一次实例化,
					allStu = new ArrayList<Student>();// 用array实例化
				}

				Student s = new Student();// new一个student实体类用于接收结果集
				s.setId(rs.getInt("id"));// 取得id并写入student实体类
				s.setName(rs.getString("name"));// 取得name并写入student实体类
				s.setMyclass(rs.getString("myclass"));// 取得myclass并写入student实体类
				s.setScore(rs.getDouble("score"));// 取得socre并写入student实体类

				allStu.add(s);// 依次添加到集合中
			}
		} catch (SQLException e) {
			System.err.println("根据班级查询学生失败,请查看具体原因!");
			e.printStackTrace();
		}
		return allStu;
	}

	/**
	 * 根据分数查询,返回一个学生列表
	 */
	public List<Student> findByScore(int score) {
		Connection conn = null;// 链接数据库
		PreparedStatement ps = null;// 预编译
		ResultSet rs = null;// 结果集--
		List<Student> allStu = null;// 储存获得的结果到列表中

		try {
			conn = JDBCUtils.getConnection();// 获得数据库链接
			String sql = "select * from t_student where score < ?";// SQL语句
			ps = conn.prepareStatement(sql);// 用SQL语句实例化prepareStatement
			ps.setInt(1, score);// 传入的score
			rs = ps.executeQuery();// 执行查询并获得结果集

			while (rs.next()) {// 如果结果不为空
				if (allStu == null) {// 只需要第一次实例化,
					allStu = new ArrayList<Student>();// 用array实例化
				}

				Student s = new Student();// new一个student实体类用于接收结果集
				s.setId(rs.getInt("id"));// 取得id并写入student实体类
				s.setName(rs.getString("name"));// 取得name并写入student实体类
				s.setMyclass(rs.getString("myclass"));// 取得myclass并写入student实体类
				s.setScore(rs.getDouble("score"));// 取得socre并写入student实体类

				allStu.add(s);// 依次添加到集合中
			}
		} catch (SQLException e) {
			System.err.println("根据分数查询学生失败,请查看具体原因!");
			e.printStackTrace();
		}
		return allStu;
	}

	
	/**
	 * 根据学号查询学生
	 */
	public Student findById(int sid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		Student stu = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_student where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);// 传入的id

			rs = ps.executeQuery();

			if (rs.next()) {

				stu = new Student();

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String myclass = rs.getString("myclass");
				double socre = rs.getDouble("score");

				stu.setId(id);
				stu.setName(name);
				stu.setMyclass(myclass);
				stu.setScore(socre);

			}

		} catch (SQLException e) {
			System.err.println("根据学号查询学生失败,请查看具体原因!");
			e.printStackTrace();
		}
		return stu;// 返回一个学生
	}

	/**
	 * 根据姓名查询学生
	 */
	public List<Student> findByName(String sname) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Student> allStu = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select * from t_student where name like ";
			sql = sql + "'%"+sname+"%'";//支持了模糊查询
			ps = conn.prepareStatement(sql);
			//ps.setString(1, sname);

			rs = ps.executeQuery();

			while (rs.next()) {// 如果结果不为空
				if (allStu == null) {// 只需要第一次实例化,
					allStu = new ArrayList<Student>();// 用array实例化
				}

				Student s = new Student();// new一个student实体类用于接收结果集
				s.setId(rs.getInt("id"));// 取得id并写入student实体类
				s.setName(rs.getString("name"));// 取得name并写入student实体类
				s.setMyclass(rs.getString("myclass"));// 取得myclass并写入student实体类
				s.setScore(rs.getDouble("score"));// 取得socre并写入student实体类

				allStu.add(s);// 依次添加到集合中
			}
		} catch (SQLException e) {
			System.err.println("根据姓名查询学生失败,请查看具体原因!");
			e.printStackTrace();
		}
		return allStu;
	}

	/**
	 * 增加一个学生,传入姓名,班级,成绩,学号是自增的
	 */
	public int add(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into t_student(name,myclass,score) values(?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getMyclass());
			ps.setDouble(3, student.getScore());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改一个学生 根据传入的学生类,的学号,修改其他的信息(学号是主键)
	 */
	public int modify(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "update t_student set name=?,myclass=?,score=? where id = ?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setString(2, student.getMyclass());
			ps.setDouble(3, student.getScore());
			ps.setInt(4, student.getId());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("添加学生失败,请查看具体原因!");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 删除一个学生.根据传入的学号查找
	 */
	public int delete(int sid) {
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "delete from t_student where id = ?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, sid);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("删除学生失败,请查看具体原因!");
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * 返回学生表的所有行数
	 */
	@Override
	public int findTotalCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int totalCount = 0;
		
		try{
			conn = JDBCUtils.getConnection();
			//此条语句返回一列,名为totalCount,值为所有的行数,这样方便在ResultSet结果集中取值
			String sql = "select count(*) as totalCount from t_student ";
			ps = conn.prepareStatement(sql);
						
			rs = ps.executeQuery();
			
			if(rs.next()){
				totalCount = rs.getInt("totalCount");
			}
			
			
		}catch(SQLException e){
			System.err.println("返回学生列表所有行数失败,请查看具体原因!");
			e.printStackTrace();
		}
		
		return totalCount;
	}

	/**
	 * 学生列表分页查询,返回一个已经分页的学生列表
	 */
	@Override
	public List<Student> findOnePage(int pageIndex, int pageSize) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Student> stuList = null;// 储存获得的结果到列表中
		
		try{
			conn = JDBCUtils.getConnection();
			//分页查询 limit 起始行数 显示的行数
			String sql = "select * from t_student limit ?,?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, (pageIndex - 1)* pageSize);//起始行数 = (当前页数 - 1) * 每页显示的行数
			ps.setInt(2, pageSize);	//每页显示的行数		
			
			rs = ps.executeQuery();
			
			while (rs.next()) {// 如果结果不为空
				if (stuList == null) {// 只需要第一次实例化,
					stuList = new ArrayList<Student>();// 用array实例化
				}

				Student s = new Student();// new一个student实体类用于接收结果集
				s.setId(rs.getInt("id"));// 取得id并写入student实体类
				s.setName(rs.getString("name"));// 取得name并写入student实体类
				s.setMyclass(rs.getString("myclass"));// 取得myclass并写入student实体类
				s.setScore(rs.getDouble("score"));// 取得socre并写入student实体类

				stuList.add(s);// 依次添加到集合中
			}
		}catch(SQLException e){
			System.err.println("学生列表分页查询失败,请查看具体原因!");
			e.printStackTrace();
		}
		return stuList;//返回一个已经分页的学生列表
	}

}
