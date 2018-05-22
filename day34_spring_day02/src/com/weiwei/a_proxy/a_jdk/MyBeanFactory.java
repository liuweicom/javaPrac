package com.weiwei.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {
	public static UserService createService(){
		//创建目标类
		final UserService userService = new UserServiceImpl();
		//切面类
		final MyAspect myAspect = new MyAspect();
		//代理类：
		/**
		 * 代理类，将目标类（切入点）和切面类（通知）结合--》切面
		 * Proxy.newProxyInstance()
		 * 	参数1：loader，类加载器，动态代理类，运行时创建，任何类都需要类加载器将其加载到内存中
		 * 		一般情况下：当前类。class.getClassLoader();
		 * 				目标类.getClass().getClassLoader()
		 * 	参数2：class[] interface 代理类需要实现的所有接口
		 * 			方式一：目标类实例.getClass().getInterface()
		 * 			方式二：new Class[]{UserService.class}
		 * 			例如：jdbc 驱动  --> DriverManager  获得接口 Connection
		 * 	参数3：InvocationHandler 处理类是接口，必须进行实现类，一般采用匿名内部类
		 * 		提供 invoke方法，代理类的每一个方法执行时都将调用一次invoke
		 * 		参数31：Object proxy：代理对象
		 * 		参数32：Method method：代理对象当前执行的方法的描述对象（反射）
		 * 		参数33：Object【】 args:方法实际参数
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
