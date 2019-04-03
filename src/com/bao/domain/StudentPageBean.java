package com.bao.domain;

import java.util.List;

/**
 * 学生分页实体类
 * @param <T>
 */
public class StudentPageBean<T> {
	private int pageIndex;// 当前页号
	private int pageSize;// 每页的数据条数
	private int count;// 数据总条数
	private int pageCount;// 一共的页数
	private int start;// 起始数据位置
	private int end;// 结束
	private List<T> list = null; // 存储当前页记录的集合

	/**
	 * 一些所需的初始化参数
	 */
	public void init(){
		//1.计算总页数pageCount
		if(count % pageSize == 0)//恰好是每页行数的整数倍
			pageCount = count / pageSize;
		else					//超出则+1
			pageCount = count / pageSize + 1;
		
		//2.判断当前页号pageIndex是否合法
		if(pageIndex < 1)
			pageIndex = 1;
		if(pageIndex > pageCount)
			pageIndex = pageCount;
		
		//3.计算当前页的第一条 和 最后一条的位置
		start = (pageIndex - 1) * pageSize;
		
		if((pageIndex * pageSize) > count)//如果最后总行数不是每页行数的整数倍,则证明最后一页不满,最后一行即为总行数
			end = count;
		else
			end = start + pageSize;//否则则是整数倍
	}
	
	public StudentPageBean() {
		super();
	}

	public StudentPageBean(int pageIndex, int pageSize, int count) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.count = count;
	}

	public StudentPageBean(int pageIndex, int pageSize, int count, List<T> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.count = count;
		this.list = list;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
