package com.weiwei.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
public class UserDaoImpl implements UserDao {

	// 闇�鍚慸ao瀹炵幇绫讳腑娉ㄥ叆SqlSessionFactory
	// 杩欓噷閫氳繃鏋勯�鏂规硶娉ㄥ叆
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = sqlSession.selectOne("test.findUserById", id);

		// 閲婃斁璧勬簮
		sqlSession.close();

		return user;

	}
	
	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName", name);

		// 閲婃斁璧勬簮
		sqlSession.close();

		return list;
	}
	

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//鎵ц鎻掑叆鎿嶄綔
		sqlSession.insert("test.insertUser", user);

		// 鎻愪氦浜嬪姟
		sqlSession.commit();

		// 閲婃斁璧勬簮
		sqlSession.close();

	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//鎵ц鎻掑叆鎿嶄綔
		sqlSession.delete("test.deleteUser", id);

		// 鎻愪氦浜嬪姟
		sqlSession.commit();

		// 閲婃斁璧勬簮
		sqlSession.close();

	}



}
