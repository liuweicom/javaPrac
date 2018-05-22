package com.weiwei.mybatis.mapper;

import java.util.List;

import com.weiwei.mybatis.pojo.User;
import com.weiwei.mybatis.pojo.UserCustomer;
import com.weiwei.mybatis.pojo.UserQueryVo;

public interface UserMapper {
	//�û���Ϣ�ۺϲ�ѯ
	public List<UserCustomer> findUserList(UserQueryVo UserQueryVo) throws Exception;
	//�û���Ϣ�ۺϲ�ѯ����
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//����id��ѯ�û���Ϣ
	public User findUserById(int id) throws Exception;
	
	//����id��ѯ�û���Ϣ��ʹ��resultMap���
	public User findUserByIdResultMap(int id) throws Exception;
	
	//�����û����в�ѯ�û��б�
	public List<User> findUserByName(String name) throws Exception;
	
	//�����û�
	public void insertUser(User user) throws Exception;
	
	//ɾ���û�
	public void deleteUser(int id) throws Exception;
}
