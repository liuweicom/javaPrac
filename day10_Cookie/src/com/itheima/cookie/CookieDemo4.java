package com.itheima.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo4 extends HttpServlet {

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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//获取表单数据
		String username=request.getParameter("username");
		String remember=request.getParameter("remember");
		Cookie ck=new Cookie("username",username);
		//处理业务逻辑
		//分发转向
		if("tom".equals(username)){
			if(remember!=null){
				ck.setMaxAge(Integer.MAX_VALUE);//这是cookies的有效保存时间
			}else{
				ck.setMaxAge(0);//删除cookies
			}
			response.addCookie(ck);//将cookies写回到客户端
			out.write("登录成功|");
		}else{
			out.write("登录失败|");
			//设置2秒跳转到重新登录
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/CookieDemo3");
		}
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
