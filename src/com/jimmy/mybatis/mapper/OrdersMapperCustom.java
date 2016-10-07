package com.jimmy.mybatis.mapper;

import java.util.List;

import com.jimmy.mybatis.po.Orders;
import com.jimmy.mybatis.po.OrdersCustom;
import com.jimmy.mybatis.po.User;

public interface OrdersMapperCustom {
	
	public List<OrdersCustom> findOrdersUser() throws Exception;
	
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	public List<Orders> findOrdersAndDetailsResultMap() throws Exception;
	
	public List<User> findUserAndItemResultMap() throws Exception;
}
