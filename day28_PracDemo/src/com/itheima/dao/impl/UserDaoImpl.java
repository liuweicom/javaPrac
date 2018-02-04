package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

import com.itheima.Util.JNDIUtil;
import com.itheima.dao.IUserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements IUserDao{

	private QueryRunner qr=new QueryRunner(JNDIUtil.getDataSource());
	@Override
	public User selectUserByInfo(String logonName, String logonPwd) {
		// TODO Auto-generated method stub
		try{
			return qr.query("select * from s_user where logonName=? and logonPwd=? ", new BeanHandler<User>(User.class),logonName,logonPwd);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		try {
			return qr.update("insert into s_user (userID,userName,logonName,logonPwd,gender,birthday,telephone,hobby,path,filename,remark)values(?,?,?,?,?,?,?,?,?,?,?,?)",
					user.getUserID(),user.getUserName(),user.getLogonName(),user.getLogonPwd(),user.getGender(),user.getBirthday(),user.getTelephone(),user.getHobby()
					,user.getPath(),user.getFilename(),user.getRemark());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int updateUser(User user) {
		try {
			return qr.update("update  s_user set userName=?,logonName=?,logonPwd=?,gender=?,birthday=?,education=?,telephone=?,hobby=?,path=?,filename=?,remark=?where userID=?",
					user.getUserName(),user.getLogonName(),user.getLogonPwd(),user.getGender(),user.getBirthday(),user.getEducation(),user.getTelephone(),user.getHobby()
					,user.getPath(),user.getFilename(),user.getRemark(),user.getUserID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int deleteUser(Integer userID) {
		// TODO Auto-generated method stub
		try {
			return qr.update("delete from s_user where userID=?",userID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public User selectUserById(Integer userID) {
		try {
			return qr.query("select * from s_user where userID=?",new BeanHandler<User>(User.class),userID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		try {
			return qr.query("select * from s_user", new BeanListHandler<User>(User.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> selectUserByCondition(String userName, String gender,
			String education, String isUpload) {
		
		if(StringUtils.isBlank(userName)&&StringUtils.isBlank(gender)&&StringUtils.isBlank(education)&&StringUtils.isBlank(isUpload)){
			return selectAllUser();
		}else{
			try {
			List<Object>parameters=new ArrayList<Object>();
			String sql="select * from s_user";
			StringBuffer ss=new StringBuffer(sql);
			ss.append("where 1=1");
			if(StringUtils.isNotBlank(userName)){
				ss.append(" and userName like ?");
				parameters.add("%"+userName+"%");
			}
			if(StringUtils.isNotBlank(gender)){
				ss.append(" and gender = ?");
				parameters.add(gender);
			}
			if(StringUtils.isNotBlank(education)){
				ss.append(" and education = ?");
				parameters.add(education);
			}
			if(StringUtils.isNotBlank(isUpload)){
				if("true".equals(isUpload)){
					ss.append(" and isUpload is not null");
				}else{
					ss.append(" and isUpload is  null");
				}
			}
			sql = ss.toString();
			
			return qr.query(sql, new BeanListHandler<User>(User.class), parameters.toArray());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	}
	
}
