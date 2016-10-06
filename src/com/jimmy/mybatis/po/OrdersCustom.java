package com.jimmy.mybatis.po;

import java.util.Date;

//通过此类映射订单和用户查询的结果，让此类集成包括字段较多的pojo类
public class OrdersCustom extends Orders {
	
	//添加用户属性
	private String username;
	private Date birthday;
	private String sex;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
