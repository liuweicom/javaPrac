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
		//mybatis�����ļ�
		String resource = "sqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����滭���̣�����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//ͨ�������õ�sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		/**
		 * ͨ��SqlSession�������ݿ�
		 * ��һ����������ӳ���ļ���statement��ID������=namespace+������+statement��ID
		 * �ڶ���������ָ����ӳ���ļ�����ƥ���paramterType���͵Ĳ���
		 * sqlSession.selectOne�����ӳ���ļ�����ƥ���resultType���͵Ķ���
		 * selectOne��ѯ��һ����¼
		 */
		User user = sqlSession.selectOne("test.findUserById",1);
		System.out.println(user);
		
		//�ͷ���Դ
		sqlSession.close();
		//
		
	}
	
	//�����û�����ģ����ѯ�û��б�
	@Test
	public void findUserByNameTest() throws Exception{
		//mybatis�����ļ�
		String resource = "sqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����滭���̣�����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//ͨ�������õ�sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> list = sqlSession.selectList("test.findUserByName", "o");
		System.out.println(list);
		//�ͷ���Դ
		sqlSession.close();
		//
		
	}
	
	//����û���Ϣ
	@Test
	public void insertUserTest() throws Exception{
		//mybatis�����ļ�
		String resource = "sqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����滭���̣�����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//ͨ�������õ�sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("С��");
		user.setSex("��");
		user.setBirthday(new Date());
		user.setAddress("�Ϻ�");
		sqlSession.insert("test.insertUser",user);
		
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
		//
		
	}
	
	//����IDɾ���û���Ϣ
	@Test
	public void deleteUserTest() throws Exception{
		//mybatis�����ļ�
		String resource = "sqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����滭���̣�����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//ͨ�������õ�sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		

		sqlSession.delete("test.deleteUser", 2);
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
		//
		
	}
	//�����û���Ϣ
	@Test
	public void updateUserTest() throws Exception{
		//mybatis�����ļ�
		String resource = "sqlMapConfig.xml";
		//�õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����滭���̣�����mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//ͨ�������õ�sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(3);
		user.setUsername("С��");
		user.setSex("��");
		user.setBirthday(new Date());
		user.setAddress("�Ϻ�");
		sqlSession.update("test.updateUser",user);

		
		//�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
		//
	}
	
}
