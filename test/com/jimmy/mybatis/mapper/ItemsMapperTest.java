package com.jimmy.mybatis.mapper;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jimmy.mybatis.po.Items;
import com.jimmy.mybatis.po.ItemsExample;

public class ItemsMapperTest {

	private ApplicationContext ctx;
	private ItemsMapper itemsMapper;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		itemsMapper = (ItemsMapper) ctx.getBean("itemsMapper");
	}
	
	@Test
	public void testDeleteByPrimaryKey() {
		
	}

	@Test
	public void testInsert() {
		
	}

	//自定义条件查询
	@Test
	public void testSelectByExample() {
		ItemsExample example = new ItemsExample();
		//通过criteria构造查询条件
		ItemsExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("笔记本");
		
		List<Items> list = itemsMapper.selectByExample(example);
		
		System.out.println(list);
	}

	//根据主键查询
	@Test
	public void testSelectByPrimaryKey() {
		Items items = itemsMapper.selectByPrimaryKey(1);
		System.out.println(items);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		
		Items items = itemsMapper.selectByPrimaryKey(1);
		items.setName("水杯");
		//对所有字段进行更新，需要先查询出来再更新
		itemsMapper.updateByPrimaryKey(items);
		
		//如果传入字段不为空才更新，在批量更新中使用此方法，不需要先查询出来
		//itemsMapper.updateByPrimaryKeySelective(record)
	}

}
