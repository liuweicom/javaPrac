package com.weiwei.mybatis.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.weiwei.mybatis.mapper.OrderMapperCustom;
import com.weiwei.mybatis.mapper.UserMapper;
import com.weiwei.mybatis.pojo.Orders;
import com.weiwei.mybatis.pojo.OrdersCustom;
import com.weiwei.mybatis.pojo.User;

public class OrdersMapperCustomTest {
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
		OrderMapperCustom userMapper = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<OrdersCustom> list = userMapper.findOrdersUser();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	
	@Test
	public void findOrdersUserResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapperCustom userMapper = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<Orders> list = userMapper.findOrdersUserResultMap();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void findOrdersAndOrderDetailResultMap() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapperCustom userMapper = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<Orders> list = userMapper.findOrdersAndOrderDetailResultMap();
		System.out.println(list);
		
		sqlSession.close();
	}
	
	//��ѯ����������ѯ�û����û���Ϣʹ���ӳټ���
	@Test
	public void findOrdersUserLazyLoading() throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapperCustom userMapper = sqlSession.getMapper(OrderMapperCustom.class);
		
		List<Orders> list = userMapper.findOrdersUserLazyLoading();
		for(Orders orders:list){
			User user = orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();
	}
	
		//һ���������
		@Test
		public void testCache1() throws Exception{
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			/**
			 * �±߲�ѯʹ��һ��sqlSession
			 * ��һ�η������󣬲�ѯIDΪ1���û�
			 */
//			User user = userMapper.findUserById(1);
//			System.out.println(user);
//			user.setUsername("С����");
//			userMapper.updateUser(user);
//			sqlSession.commit();
			
			User user2 = userMapper.findUserById(1);
			System.out.println(user2);//���ڻ���ֻ������һ���������ݿ�
			
			/**
			 * ���sqlSessionȥִ��commit������ִ�в��룬���£�ɾ����
			 * ���sqlSession�е�һ�����棬��������Ŀ��Ϊ���û����д��ڵ������µ���Ϣ���������
			 */
			sqlSession.close();
		}
		
		
				//�����������
				@Test
				public void testCache2() throws Exception{
					SqlSession sqlSession = sqlSessionFactory.openSession();
					SqlSession sqlSession2 = sqlSessionFactory.openSession();
					SqlSession sqlSession3 = sqlSessionFactory.openSession();
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
					
					
					User user1 = userMapper.findUserById(1);
					System.out.println(user1);//���ڻ���ֻ������һ���������ݿ�
					sqlSession.commit();
					/**
					 * ʹ��sqlSessionִ��commit��������
					 	UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
						User user  = userMapper3.findUserById(1);
						user.setUsername("������");
						userMapper3.updateUser(User);
						ִ���ύ�����UserMapper�±ߵĶ�������
						sqlSession.commit();
						sqlSession.close();
					 */
					UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
					User user2 = userMapper.findUserById(1);
					System.out.println(user2);//���ڻ���ֻ������һ���������ݿ�
					
					
					/**
					 * ִ���ύ�����UserMapper�±ߵĶ�������
					 */
					sqlSession.close();
				}
		
}
