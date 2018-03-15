package com.itheima.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//通过路径得到一个输入流
		String path=this.getServletContext().getRealPath("WEB-INF/classes/桌面.jpeg");
		FileInputStream fis=new FileInputStream(path);
		//创建字节输出流
		ServletOutputStream sos=response.getOutputStream();
		//得到要下载的文件名
		String filename=path.substring(path.lastIndexOf("\\")+1);
		//设置文件名的编码,如果不告知，服务器无法识别中文，得到的文件名为空
		filename=URLEncoder.encode(filename,"UTF-8");
		//告知客户端要下载的文件
		response.setHeader("content-disposition","attachment;filename"+filename);
		response.setHeader("content-type", "image/jpeg");
		//执行输出操作
		int len=1;
		byte[] b=new byte[1024];
		while((len=fis.read(b))!=-1){
			sos.write(b,0,len);
		}
		sos.close();
		fis.close();
		//下载图片的名字变成了ServletDemo3？？？？？？？？？？？？？打印在控制太的名字仍为原名
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
