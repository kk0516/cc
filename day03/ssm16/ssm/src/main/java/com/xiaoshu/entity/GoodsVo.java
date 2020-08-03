package com.xiaoshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GoodsVo extends Goods {
	private String tname;
  @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start;
	@DateTimeFormat(pattern="yyyy-MM-dd")
private Date end;
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public Date getStart() {
	return start;
}
public void setStart(Date start) {
	this.start = start;
}
public Date getEnd() {
	return end;
}
public void setEnd(Date end) {
	this.end = end;
}
public GoodsVo(String tname, Date start, Date end) {
	super();
	this.tname = tname;
	this.start = start;
	this.end = end;
}
public GoodsVo() {
	super();
	// TODO Auto-generated constructor stub
}



}
