package com.itheima.servlet;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.entity.User;

public class ServletDemo3 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//告诉服务器要使用什么编码，注：浏览器使用的是什么编码传过来的就是什么编码
		request.setCharacterEncoding("Utf-8");//只能解决post方式的乱码
//		test1(request);
		
//		test2(request);
//		test3(request);		
		test4(request); 
		//
		//
	}

	private void test4(HttpServletRequest request) {
		//通过导包，直接获得了插件，插件复制
		try {
			User u=new User();
			System.out.println("封装数据钱："+u);
			BeanUtils.populate(u,request.getParameterMap());
			System.out.println("封装数据后:"+u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test3(HttpServletRequest request) {
		try {
		//获取表单数据
		User u=new User();
		System.out.println("封装数据钱："+u);
		Map<String,String[]> map=request.getParameterMap();
		for(Map.Entry<String,String[]>m:map.entrySet()){
			String name=m.getKey();
			String[] value=m.getValue();
			//创建一属性描述器
			PropertyDescriptor pd;
			
			pd = new PropertyDescriptor(name,User.class);
			//得到setter属性
			Method setter=pd.getWriteMethod();
			if(value.length==1){
				setter.invoke(u,value[0]);//给一个值的变量复制
			}else{
				setter.invoke(u,(Object)value);//相当于给复选框类似的赋值
			}
			System.out.println("封装数据后:"+u);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void test2(HttpServletRequest request) {
		//获取所有表单name的名字
		Enumeration names=request.getParameterNames();
		while(names.hasMoreElements()){
			String name=(String) names.nextElement();
			String[] values=request.getParameterValues(name);
			for(int i=0;values!=null&&i<values.length;i++){
				System.out.println(name+":"+values[i]);
			}
		}
	}

	private void test1(HttpServletRequest request) {
		//获取表单数据
		//根据表单中的name属性名，获取value属性的值的方法
		String userName=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		String sex=request.getParameter("sex");
		String [] hobbys=request.getParameterValues("hobby");
		
		String city=request.getParameter("city");
		System.out.println(userName);
		System.out.println(pwd);
		System.out.println(sex);
		for(int i=0;hobbys!=null && i<hobbys.length;i++){
			System.out.print(hobbys[i]+"\t");
		}
		System.out.println(city);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
