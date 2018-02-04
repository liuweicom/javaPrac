package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 自定义拦截器
 * 第一步：创建一个普通类，继承AbstractInterceptor,实现抽象方法Interceptor
 * 第二部：在Struts。mxl中配置拦截器：
 * 		1.申明拦截器
 * 			<interceptors>
				<interceptor name="demo1Interceptor" class="com.itheima.web.interceptor.Demo1Interceptor" />
			</interceptors>
 * 		2.使用拦截器
 * 			<!--使用自定义拦截器：当配置了任何一个拦截器，默认的拦截器就不会再工作了 -->
 *          <interceptor-ref name="demo1Interceptor"></interceptor-ref>
 * @author Administrator
 *
 */
public class Demoiterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DemoInterceptor拦截器，在拦截了--执行了动作方法之前");
		//1.获取HTTPSession
		HttpSession session=ServletActionContext.getRequest().getSession();
		//2.获取session域中的登录标记
		Object obj=session.getAttribute("user");
		//3.判断是否有登录标记
		if(obj==null){
			return "input";
		}
		String value=invocation.invoke();//就是结果视图的结果
		System.out.println(value);
		System.out.println("DemoInterceptor拦截器，在执行了动作方法之后");
		return value;
	}

}
