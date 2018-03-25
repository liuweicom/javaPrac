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
		//���߿ͻ��˲�ʹ�û���
			response.setHeader("param", "no-cache");
			response.setHeader("cache-control", "no-cache");
			response.setIntHeader("expires", 0);
			
//			ValidateCode vc=new ValidateCode(110,25,4,9);
//			String code=vc.getCode();//�õ����ɵ��ַ�
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
		//���ڴ��ڴ���һ��ͼ�����
		BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//����һ���ʻ�
		Graphics g=img.getGraphics();
		//��ͼƬ��ӱ���
		g.setColor(Color.white);
		g.fillRect(1, 1, width-2, height-2);
		//���߿�һ��ɫ
		g.setColor(Color.BLUE);
		g.drawRect(0,0,width-1,height-1);
		//�����ı���ʽ
		g.setColor(Color.BLUE);
		g.setFont(new Font("����",Font.BOLD|Font.ITALIC,15));
		
		//��ͼƬ����ı�
		Random rand=new Random();
		for(int i=0;i<4;i++){
			g.drawString(rand.nextInt(10)+"", (i+1)*20, 20);
		}
		//��Ӹ�����
		for(int i=0;i<9;i++){
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width),rand.nextInt(height));
		}
		
		//��ͼƬ���������ķ�ʽ����Ŀͻ���
		
		ImageIO.write(img,"jpg",response.getOutputStream());
	}

}
