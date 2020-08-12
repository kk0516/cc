package com.xiaoshu.entity;

public class ContentVo extends Content {
private String cname;

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public ContentVo(String cname) {
	super();
	this.cname = cname;
}
public ContentVo(){
	
}
}
