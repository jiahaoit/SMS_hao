package com.bao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bao.domain.Student;
import com.bao.utils.JDBCUtils;

/**
 * 登录信息验证
 */
public class ApplicantDAO {
	/**
	 * 根据账号和密码验证登录,返回登录账号.不为空,则证明登录成功
	 */
	public String login(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String loginUsername = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select username from idinfo where username = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);// 传入的账户和密码
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {
				loginUsername = rs.getString("username");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginUsername;// 返回一个学生的账号
	}

	/**
	 * 根据账号,修改密码
	 */
	public void SaveUpdate(String username,String newpassword) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE idinfo SET password = ? WHERE username = ?";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newpassword);
			ps.setString(2, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据账号返回密码,用于验证修改密码
	 */
	public String isUpdate(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String password = null;

		try {
			conn = JDBCUtils.getConnection();
			String sql = "select password from idinfo where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);// 传入的账户

			rs = ps.executeQuery();

			if (rs.next()) {
				password = rs.getString("password");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;// 返回一个密码
	}

	/**
	 * 验证账号是否已被注册 根据用户输入的账号,查询所有,有结果集则已经存在此邮箱,提示
	 */
	public boolean isExistUsername(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM idinfo WHERE username=?";// 查询所有
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next())
				return true;// 有则为true
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 注册信息保存 根据用户输入的账号和密码,插入到表中
	 */
	public void save(String username, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO idinfo(username,password) VALUES(?,?)";
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
