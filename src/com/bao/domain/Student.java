package com.bao.domain;
/**
 * 学生实体类
 * @author Administrator
 *
 */
public class Student {
	//和数据库对应的4个属性
	private int id;//主键学号是唯一的,自增
	private String name;
	private String myclass;
	private double score;
	
	
	/**
	 * 根据学生姓名,班级,和成绩创建新的学生类
	 * @param name
	 * @param myclass
	 * @param socre
	 */
	public Student(String name, String myclass, double score) {
		this.name = name;
		this.myclass = myclass;
		this.score = score;
	}
	public Student(int id, String name, String myclass, double score) {
		super();
		this.id = id;
		this.name = name;
		this.myclass = myclass;
		this.score = score;
	}

	/**
	 * 无参构造
	 */
	public Student() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMyclass() {
		return myclass;
	}
	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "id = " + this.id + 
				" name = " + this.name + 
				" myclass = " + this.myclass + 
				" score = " + this.score;
	}
}
