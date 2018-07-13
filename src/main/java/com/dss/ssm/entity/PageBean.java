package com.dss.ssm.entity;

import java.util.List;
import java.util.Map;

public class PageBean {

	private int total;
	private List<Map<String, Object>> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "UserPage [total=" + total + ", rows=" + rows + "]";
	}

	public PageBean(int total, List<Map<String, Object>> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public PageBean() {
		super();
	}
}
