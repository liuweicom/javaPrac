package com.itheima.web.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 检查登录的拦截器,最终版本
 * @author zhy
 *
 */
public class Demoiterceptor1 extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
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
