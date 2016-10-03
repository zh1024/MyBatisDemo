package com.jimmy.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.jimmy.mybatis.po.User;

public class MyBatisFirst {

	//根据id查询用户信息，得到一条记录
	@Test
	public void findUserByIdTest() throws IOException {
		
		//MyBatis的配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		
		//创建会话工厂SqlSessionFactory，需要传入MyBatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//通过会话工厂得到会话SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过会话操作数据库
		//第一个参数：映射文件中statement的id，等于namespace.statement的id
		//第二个参数：指定与映射文件中parameterType类型相匹配的的参数
		//sqlSession.selectOne应该返回与映射文件中resultType类型相匹配的对象
		User user = sqlSession.selectOne("test.findUserById", 1);
		
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
	}

}
