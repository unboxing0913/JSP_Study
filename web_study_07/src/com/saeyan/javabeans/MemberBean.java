package com.saeyan.javabeans;

public class MemberBean {
	private String name; //property (Bean클래스에서)
	private String userid;
	
	public MemberBean() {
		
	}

	public MemberBean(String name,String userid) {
		this.name=name;
		this.userid=userid;
	}

	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MemberBean [name=" + name + ", userid=" + userid + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
