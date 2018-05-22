package com.weiwei.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * cglib
 * û�нӿڣ�ֻ��ʵ����
 * �����ֽ�����ǿ���cglib������ʱ������Ŀ��������࣬�Ӷ���Ŀ���������ǿ
 * 
 * @author ����
 *
 */
public class MyBeanFactory {
	public static UserServiceImpl createService(){
		//����Ŀ����
		final UserServiceImpl userService = new UserServiceImpl();
		//������
		final MyAspect myAspect = new MyAspect();
		//�����ࣺ
		/**
		 * �����࣬����cglib���ײ㴴��Ŀ���������
		 * ������Enhancer
		 * ȷ������
		 * ���ûص�������MethodInterceptor�ӿڵ�Чjdk InvacationHander�ӿ�
		 * 	intercept()��Чjdk invoke()
		 * 		����1������2������3����invokeһ��
		 * ����4��methodProxy��������
		 * 
		 */
		//������Enhancer
		Enhancer enhancer = new Enhancer();
		//ȷ������
		enhancer.setSuperclass(userService.getClass());
//		���ûص�������MethodInterceptor�ӿڵ�Чjdk InvacationHander�ӿ�
//		 * 	intercept()��Чjdk invoke()
//		 * 		����1������2������3����invokeһ��
//		 * ����4��methodProxy��������
		enhancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				myAspect.before();
				Object obj = method.invoke(userService, args);
				//ִ�д�����ĸ��࣬Ҳ����ִ��Ŀ���࣬Ŀ�����Ǵ�����ĸ��ࡣ
				myAspect.after();
				// TODO Auto-generated method stub
				return obj;
			}
			
		});
		
		//3.4��������
		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
		return proxyService;
	}
}
