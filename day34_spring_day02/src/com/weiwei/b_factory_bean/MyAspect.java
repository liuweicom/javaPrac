package com.weiwei.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * ��������ȷ��֪ͨ����Ҫʵ�ֲ�ͬ�ӿڣ��ӿھ��ǹ淶���Ӷ�ȷ����������
 * ���û���֪ͨMethodIntercaptor
 * *****���Ʒ��������ֶ�ִ��Ŀ�귢����
 * @author ����
 *
 */
public class MyAspect implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("ǰ");
		Object obj = mi.proceed();
		System.out.println("��");
		return obj;
	}
	
}
