package com.jimmy.mybatis.po;

import java.util.List;

public class UserQueryVo {

	//包装所需要的查询条件
	
	//传入多个id
	private List<Integer> ids;
	
	//用户的查询条件
	private UserCustom userCustom;
	
	//还可以包装其他的查询条件，比如：订单、商品...

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
