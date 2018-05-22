package com.weiwei.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
	public static UserService createService(){
		//����Ŀ����
		final UserService userService = new UserServiceImpl();
		//������
		final MyAspect myAspect = new MyAspect();
		//�����ࣺ
		/**
		 * �����࣬��Ŀ���ࣨ����㣩�������֪ࣨͨ�����--������
		 * Proxy.newProxyInstance()
		 * 	����1��loader�������������̬�����࣬����ʱ�������κ��඼��Ҫ�������������ص��ڴ���
		 * 		һ������£���ǰ�ࡣclass.getClassLoader();
		 * 				Ŀ����.getClass().getClassLoader()
		 * 	����2��class[] interface ��������Ҫʵ�ֵ����нӿ�
		 * 			��ʽһ��Ŀ����ʵ��.getClass().getInterface()
		 * 			��ʽ����new Class[]{UserService.class}
		 * 			���磺jdbc ����  --> DriverManager  ��ýӿ� Connection
		 * 	����3��InvocationHandler �������ǽӿڣ��������ʵ���࣬һ����������ڲ���
		 * 		�ṩ invoke�������������ÿһ������ִ��ʱ��������һ��invoke
		 * 		����31��Object proxy���������
		 * 		����32��Method method���������ǰִ�еķ������������󣨷��䣩
		 * 		����33��Object���� args:����ʵ�ʲ���
		 * 
		 */
		
		UserService proxyService = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				myAspect.before();
				Object obj = method.invoke(userService, args);
				myAspect.after();
				// TODO Auto-generated method stub
				return obj;
			}
			
		});
		return proxyService;
	}
}
