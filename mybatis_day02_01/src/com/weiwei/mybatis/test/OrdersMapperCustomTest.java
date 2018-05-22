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
	
	//查询订单关联查询用户，用户信息使用延迟加载
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
	
		//一级缓存测试
		@Test
		public void testCache1() throws Exception{
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			/**
			 * 下边查询使用一个sqlSession
			 * 第一次发起请求，查询ID为1的用户
			 */
//			User user = userMapper.findUserById(1);
//			System.out.println(user);
//			user.setUsername("小贱人");
//			userMapper.updateUser(user);
//			sqlSession.commit();
			
			User user2 = userMapper.findUserById(1);
			System.out.println(user2);//存在缓存只发送了一次请求数据库
			
			/**
			 * 如果sqlSession去执行commit操作（执行插入，更新，删除）
			 * 清空sqlSession中的一级缓存，这样做的目的为了让缓存中存在的是最新的信息，避免脏读
			 */
			sqlSession.close();
		}
		
		
				//二级缓存测试
				@Test
				public void testCache2() throws Exception{
					SqlSession sqlSession = sqlSessionFactory.openSession();
					SqlSession sqlSession2 = sqlSessionFactory.openSession();
					SqlSession sqlSession3 = sqlSessionFactory.openSession();
					UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
					
					
					User user1 = userMapper.findUserById(1);
					System.out.println(user1);//存在缓存只发送了一次请求数据库
					sqlSession.commit();
					/**
					 * 使用sqlSession执行commit（）操作
					 	UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
						User user  = userMapper3.findUserById(1);
						user.setUsername("张明明");
						userMapper3.updateUser(User);
						执行提交，清空UserMapper下边的二级缓存
						sqlSession.commit();
						sqlSession.close();
					 */
					UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
					User user2 = userMapper.findUserById(1);
					System.out.println(user2);//存在缓存只发送了一次请求数据库
					
					
					/**
					 * 执行提交，清空UserMapper下边的二级缓存
					 */
					sqlSession.close();
				}
		
}
