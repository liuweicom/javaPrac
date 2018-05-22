package com.weiwei.mybatis.mapper;

import java.util.List;

import com.weiwei.mybatis.pojo.Orders;
import com.weiwei.mybatis.pojo.OrdersCustom;
import com.weiwei.mybatis.pojo.User;

public interface OrderMapperCustom {
		//��ѯ����������ѯ�û���Ϣ
		public List<OrdersCustom> findOrdersUser()throws Exception;
		
		//��ѯ����������ѯ�û�ʹ��resultMap
		public List<Orders> findOrdersUserResultMap()throws Exception;
		
		//��ѯ����(�����û�)��������ϸ
		public List<Orders>  findOrdersAndOrderDetailResultMap()throws Exception;
		
		//��ѯ�û�������Ʒ��Ϣ
		public List<User>  findUserAndItemsResultMap()throws Exception;
		
		//��ѯ����������ѯ�û����û���Ϣ���ӳټ���
		public List<Orders> findOrdersUserLazyLoading()throws Exception;
}
