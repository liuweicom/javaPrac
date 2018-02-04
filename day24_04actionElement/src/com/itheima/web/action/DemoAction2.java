package com.itheima.web.action;

import com.opensymphony.xwork2.Action;
/**
 * 创建动作类的第二种方式
 * 	创建一个action接口的实现类，实现接口中的方法
 * 如果没有method方法，默认执行execute方法
 * @author Administrator
 *
 */
public class DemoAction2 implements Action {
/**
 * Action接口中的常量
 * SUCCESS 'success'当执行成功后，前往指定的位置
 * NODE		
 * ERROR
 * INPUT
 * LOGIN
 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
