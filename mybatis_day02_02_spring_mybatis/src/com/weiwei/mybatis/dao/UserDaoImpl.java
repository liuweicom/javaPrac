package com.weiwei.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.weiwei.mybatis.pojo.User;



/**
 * 
 * <p>
 * Title: UserDaoImpl
 * </p>
 * <p>
 * Description:dao鎺ュ彛瀹炵幇绫�
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 浼犳櫤.鐕曢潚
 * @date 2015-4-22涓嬪崍2:47:17
 * @version 1.0
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) throws Exception {
		//继承SqlSessionDaoSupport，通过this.getSqlSession()得到sqlSessoin 
		SqlSession sqlSession = this.getSqlSession();

		User user = sqlSession.selectOne("test.findUserById", id);

		// 这里会自动关闭sqlSession
//		sqlSession.close();

		return user;

	}
	



}
