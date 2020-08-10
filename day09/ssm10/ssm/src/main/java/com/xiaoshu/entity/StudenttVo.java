package com.xiaoshu.entity;

public class StudenttVo extends Studentt {
	private String sname;
	private Integer num;
	
	

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "StudenttVo [sname=" + sname + ", num=" + num + "]";
	}
	
	
}
