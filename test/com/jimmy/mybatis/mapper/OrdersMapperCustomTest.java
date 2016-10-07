package com.jimmy.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.jimmy.mybatis.po.Orders;
import com.jimmy.mybatis.po.OrdersCustom;
import com.jimmy.mybatis.po.User;

public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		
		//MyBatis的配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		
		//创建会话工厂SqlSessionFactory，需要传入MyBatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}

	@Test
	public void testFindOrdersUser() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
		
		sqlSession.close();
		
		System.out.println(list);
		
	}
	
	@Test
	public void testFindOrderUserLL() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<Orders> list = ordersMapperCustom.findOrderUserLL();
		
		for (Orders order : list) {
			order.getUser();
		}
		
		System.out.println(list);
		
		sqlSession.close();
		
		
	}

	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		
		sqlSession.close();
		
		System.out.println(list);
		
	}

	@Test
	public void testFindOrdersAndDetailsResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<Orders> list = ordersMapperCustom.findOrdersAndDetailsResultMap();
		
		sqlSession.close();
		
		System.out.println(list);
		
	}
	
	@Test
	public void testFindUserAndItemResultMap() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<User> list = ordersMapperCustom.findUserAndItemResultMap();
		
		sqlSession.close();
		
		System.out.println(list);
		
	}
}