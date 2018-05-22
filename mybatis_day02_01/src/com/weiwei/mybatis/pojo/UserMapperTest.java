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
		//mybatis�����ļ�
				String resource = "sqlMapConfig.xml";
				//�õ������ļ���
				InputStream inputStream = Resources.getResourceAsStream(resource);
				//�����滭���̣�����mybatis�������ļ���Ϣ
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserList() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustomer userCustomer = new UserCustomer();
		userCustomer.setUsername("С��");
		userCustomer.setSex("��");
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
