package com.jimmy.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.jimmy.mybatis.po.User;
import com.jimmy.mybatis.po.UserCustom;
import com.jimmy.mybatis.po.UserQueryVo;

public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		
		//MyBatis的配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		
		//创建会话工厂SqlSessionFactory，需要传入MyBatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}

	@Test
	public void testFindUserByIdResultMap() throws Exception {
		
		//通过会话工厂得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//测试userMapper的方法
		User user = userMapper.findUserByIdResultMap(1);
		
		//释放资源
		sqlSession.close();
		
		System.out.println(user);
		
	}

	@Test
	public void testFindUserList() throws Exception {
		
		//通过会话工厂得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张");
		userQueryVo.setUserCustom(userCustom);
		
		Integer[] array = {1, 10, 16};
		List<Integer> ids = Arrays.asList(array);
		userQueryVo.setIds(ids);
		
		//测试userMapper的方法
		List<UserCustom> users = userMapper.findUserList(userQueryVo);
		
		//释放资源
		sqlSession.close();
		
		System.out.println(users);
		
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		//通过会话工厂得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//测试userMapper的方法
		User user = userMapper.findUserById(1);
		
		//释放资源
		sqlSession.close();
		
		System.out.println(user);
		
	}
	
	@Test
	public void testFindUserByName() throws Exception {
		
		//通过会话工厂得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//测试userMapper的方法
		List<User> users = userMapper.findUserByName("张");
		
		//释放资源
		sqlSession.close();
		
		System.out.println(users);
		
	}
	
	@Test
	public void testInsertUser() throws Exception {
		
		//通过会话工厂得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//插入的User对象
		User user = new User();
		user.setUsername("Jimmy");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("湖北武汉");
		
		//测试userMapper的方法
		userMapper.insertUser(user);
		
		sqlSession.commit();
		sqlSession.close();
		
		System.out.println(user.getId());
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		
		//通过会话工厂得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建UserMapper对象，MyBatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//测试userMapper的方法
		userMapper.deleteUser(30);
		
		sqlSession.commit();
		
	}
	
}
