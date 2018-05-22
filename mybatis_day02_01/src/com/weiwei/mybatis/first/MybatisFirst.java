package com.weiwei.mybatis.first;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.weiwei.mybatis.pojo.User;

public class MybatisFirst {
	@Test
	public void findUserById() throws Exception{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建绘画工程，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		/**
		 * 通过SqlSession操作数据库
		 * 第一个擦参数：映射文件中statement的ID，等于=namespace+“。”+statement的ID
		 * 第二个参数：指定和映射文件中所匹配的paramterType类型的参数
		 * sqlSession.selectOne结果是映射文件中所匹配的resultType类型的对象
		 * selectOne查询出一条记录
		 */
		User user = sqlSession.selectOne("test.findUserById",1);
		System.out.println(user);
		
		//释放资源
		sqlSession.close();
		//
		
	}
	
	//更具用户名称模糊查询用户列表
	@Test
	public void findUserByNameTest() throws Exception{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建绘画工程，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("test.findUserByName", "o");
		System.out.println(list);
		//释放资源
		sqlSession.close();
		//
		
	}
	
	//添加用户信息
	@Test
	public void insertUserTest() throws Exception{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建绘画工程，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("小明");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("上海");
		sqlSession.insert("test.insertUser",user);
		
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		//
		
	}
	
	//更具ID删除用户信息
	@Test
	public void deleteUserTest() throws Exception{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建绘画工程，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		

		sqlSession.delete("test.deleteUser", 2);
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		//
		
	}
	//更新用户信息
	@Test
	public void updateUserTest() throws Exception{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建绘画工程，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(3);
		user.setUsername("小花");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("上海");
		sqlSession.update("test.updateUser",user);

		
		//提交事务
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		//
	}
	
}
