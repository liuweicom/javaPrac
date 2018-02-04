package com.itheima.web.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 需求：
 * 	  把表单中的MM/dd/yyyy格式的数据转成日期类型
 *   把数据库中的本地日期格式，转成MM/dd/yyyy形式输出
 * 
 * 自定义子类转换器：
 * 	第一步：编写一个类，继承自StrutsTypeConverter，实现convertFromString，convertToString抽象方法
 * @author zhy
 *
 */
public class MyConverType extends StrutsTypeConverter {
	
	private DateFormat format=new SimpleDateFormat("MM/dd/yyyy");
	/**
	 * 把字符串数组中的数据转成日期类型
	 * Map context：是OGNL的上下文对象，我们暂时不知道，暂时不用
	 * String[] arg1：要转换的类型
	 * Class arg2 目标类型
	 */
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		//1.先看看有没有数据
		if(arg1==null||arg1.length==0){
			return null;
		}
		//2.取出数组中的第一个数据
		String date=arg1[0];
		//3.判断目标类型的字节码是不是日期类型
		if(arg2==java.util.Date.class){
			try{
				//4.使用DataFormat进行转换，并且返回装换后的数据
				return format.parse(date);
			}catch(ParseException e){
				e.printStackTrace();
				return null;
		}
		}
		return null;
	}

	/**
	 * 把日期类型的数据转换成字符串
	 * 方法参数详解：
	 * Map arg0：是OGNL的上下文对象，我们暂时不知道，所以暂时也不用
	 * Object arg1：要转换的数据
	 */
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(arg1 instanceof Date){
			Date date=(Date) arg1;
			return format.format(date);
		}
		return null;
	}
	
}
