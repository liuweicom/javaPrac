package com.itheima.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

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
		//告诉客户端不使用缓存
			response.setHeader("param", "no-cache");
			response.setHeader("cache-control", "no-cache");
			response.setIntHeader("expires", 0);
			
//			ValidateCode vc=new ValidateCode(110,25,4,9);
//			String code=vc.getCode();//得到生成的字符
//			vc.write(response.getOutputStream());
			
			test(response);
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
	
	public void test(HttpServletResponse response) throws IOException{
		int width=210;
		int height=25;
		//在内存内创建一个图像对象
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//创建一个笔画
		Graphics g=img.getGraphics();
		//给图片添加背景
		g.setColor(Color.white);
		g.fillRect(1, 1, width-2, height-2);
		//给边框一个色
		g.setColor(Color.BLUE);
		g.drawRect(0,0,width-1,height-1);
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
		
		//给图片添加文本
		Random rand=new Random();
		for(int i=0;i<4;i++){
			g.drawString(rand.nextInt(10)+"", (i+1)*20, 20);
		}
		//添加干扰线
		for(int i=0;i<9;i++){
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width),rand.nextInt(height));
		}
		
		//将图片对象以流的方式输出的客户端
		
		ImageIO.write(img,"jpg",response.getOutputStream());
	}

}
