package com.jimmy.mybatis.mapper;

import java.util.List;

import com.jimmy.mybatis.po.User;
import com.jimmy.mybatis.po.UserCustom;
import com.jimmy.mybatis.po.UserQueryVo;

public interface UserMapper {
	
	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询用户
	public User findUserById(int id) throws Exception;
	
	//根据用户名模糊查询用户
	//如果mapper接口方法返回单个pojo对象（非集合对象），代理对象内部通过selectOne查询数据库
	//如果mapper接口方法返回集合对象，代理对象内部通过selectList查询数据库
	public List<User> findUserByName(String name) throws Exception;
	
	//添加用户
	public void insertUser(User user) throws Exception;
	
	//删除用户
	public void deleteUser(int id) throws Exception;
	
}
