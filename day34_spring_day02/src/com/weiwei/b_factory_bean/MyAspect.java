package com.weiwei.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 切面类中确定通知，需要实现不同接口，接口就是规范，从而确定方法名称
 * 采用环绕通知MethodIntercaptor
 * *****环绕方法必须手动执行目标发方法
 * @author 工号
 *
 */
public class MyAspect implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("前");
		Object obj = mi.proceed();
		System.out.println("后");
		return obj;
	}
	
}
