package com.jimmy.mybatis.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jimmy.mybatis.po.User;

public class UserMapperSpringTest {

	ApplicationContext ctx;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testFindUserById()throws Exception {
		UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

}
