package com.itheima.servletContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {

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
		test1();
		test2();
		test3();
	}
	
	//获取在服务器中的配置文件
	public void test1() throws FileNotFoundException, IOException{
		String path=this.getServletContext().getRealPath("/WEB-INF/c.properties");
		Properties pro=new Properties();
		pro.load(new FileInputStream(path));
		System.out.println(pro.get("key"));
	}
	
	//获取在服务器中的配置文件
		public void test2() throws FileNotFoundException, IOException{
			String path=this.getServletContext().getRealPath("/WEB-INF/classes/com/itheima/servletContext/a.properties");
			Properties pro=new Properties();
			pro.load(new FileInputStream(path));
			System.out.println(pro.get("key"));
		}
		//获取在服务器中的配置文件
				public void test3() throws FileNotFoundException, IOException{
					String path=this.getServletContext().getRealPath("/WEB-INF/classes/b.properties");
					Properties pro=new Properties();
					pro.load(new FileInputStream(path));
					System.out.println(pro.get("key"));
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
