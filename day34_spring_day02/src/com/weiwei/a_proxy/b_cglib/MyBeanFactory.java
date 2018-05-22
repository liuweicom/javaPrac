package com.weiwei.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
/**
 * cglib
 * 没有接口，只有实现类
 * 采用字节码增强框架cglib，运行时，创建目标类的子类，从而对目标类进行增强
 * 
 * @author 工号
 *
 */
public class MyBeanFactory {
	public static UserServiceImpl createService(){
		//创建目标类
		final UserServiceImpl userService = new UserServiceImpl();
		//切面类
		final MyAspect myAspect = new MyAspect();
		//代理类：
		/**
		 * 代理类，采用cglib，底层创建目标类的子类
		 * 核心类Enhancer
		 * 确定父类
		 * 设置回调函数，MethodInterceptor接口等效jdk InvacationHander接口
		 * 	intercept()等效jdk invoke()
		 * 		参数1，参数2，参数3：和invoke一样
		 * 参数4，methodProxy方法代理
		 * 
		 */
		//核心类Enhancer
		Enhancer enhancer = new Enhancer();
		//确定父类
		enhancer.setSuperclass(userService.getClass());
//		设置回调函数，MethodInterceptor接口等效jdk InvacationHander接口
//		 * 	intercept()等效jdk invoke()
//		 * 		参数1，参数2，参数3：和invoke一样
//		 * 参数4，methodProxy方法代理
		enhancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				myAspect.before();
				Object obj = method.invoke(userService, args);
				//执行代理类的父类，也就是执行目标类，目标类是代理类的父类。
				myAspect.after();
				// TODO Auto-generated method stub
				return obj;
			}
			
		});
		
		//3.4创建代理
		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
		return proxyService;
	}
}
