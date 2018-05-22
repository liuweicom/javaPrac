package com.weiwei.mybatis.pojo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.weiwei.mybatis.mapper.UserMapper;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception{
		//mybatis配置文件
				String resource = "sqlMapConfig.xml";
				//得到配置文件流
				InputStream inputStream = Resources.getResourceAsStream(resource);
				//创建绘画工程，传入mybatis的配置文件信息
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setUsername("小明");
		userCustomer.setSex("男");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(16);
		userQueryVo.setIds(list);
		userQueryVo.setUserCustomer(userCustomer);
		
		List<UserCustomer> list2 = userMapper.findUserList(userQueryVo);	
		System.out.println(list2);
	}
	
}
