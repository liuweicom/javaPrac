package com.itheima.web.test;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import cn.dsna.util.images.ValidateCode;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * 自定义结果类型：
 * 第一步：
 * 编写一个普通类，继承自StrutsResultSupport的类，并且重写doExcecute方法
 * @author Administrator
 *
 */
public class typeOne extends StrutsResultSupport {
	private int width;
	private int height;
	protected void doExecute(String finalLocation, ActionInvocation invocation)throws Exception{
		/**
		 * 使用第三方生成验证码的jar包
		 * 拷贝validateCode.jar到工程到的lib目录下
		 * 创建validateCode对象
		 * 获取响应对象输出流
		 * 输出到浏览器
		 */
		//创建ValidateCode的对象，参数对应：图像宽度，图像高度，数字个数，干扰线条数
		ValidateCode code=new ValidateCode(width,height,4,10);
		//获取相应对象
		HttpServletResponse response=ServletActionContext.getResponse();
		//输出到浏览器
		code.write(response.getOutputStream());
	
		
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}

