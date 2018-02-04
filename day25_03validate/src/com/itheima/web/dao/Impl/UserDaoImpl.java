package com.itheima.web.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.web.dao.UserDao;
import com.itheima.web.dao.Util.DBCPUtil;
import com.itheima.web.domain.User;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	@Override
	public User selectUserByUsername(String username) {
		// TODO Auto-generated method stub
		try{
			System.out.println(username);
			User a=qr.query("select * from user where username = ? ",new BeanHandler<User>(User.class), username);
			return a;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		try{
			return qr.update("insert into user(username,password,birthday,hobby,married)values(?,?,?,?,?)",
					user.getUsername(),user.getPassword(),user.getBirthday(),user.getHobby(),user.isMarried());
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
}
