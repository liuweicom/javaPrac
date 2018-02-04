package com.itheima.action;

import com.itheima.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class DemoAction2 extends ActionSupport {
	public String execute(){
		//获取valueStack对象的引用
		//第一种方式：获取HttpServletRequest对象，通过对象的getAttribute方法从域中获取
		//HttpServletRequest request = ServletActionContext.getRequest();
		//根据key获取valueStack对象的引用
		//ValueStack vs1=(ValueStack) request.getAttribute("structs.valueStack");
		//第二种方式：1.现获取ActionContext对象，
		//ActionContext context = ActionContext.getContext();
		//2.再取出requestMap，
		//Map<String,Object> requestAttrbute=(Map<String,Object>) context.get("request");
		//3.然后通过map的get方法获取
		//ValueStack vs2=(ValueStack)requestAttrbute.get("structs.valueStack");
		//第三种方式：使用ActionContext对象的方法，直接获取valueStack对象的引用
		//ValueStack vs3=context.getValueStack();
		
		
		//栈的操作
		ActionContext context1 = ActionContext.getContext();
		ValueStack vs = context1.getValueStack();
		//压栈操作
		vs.push (new Student("泰斯特",21));
		//valueSta的其他操作：
		//setValue（String express，Object Value）
		//String express:它就是一个ognl表达式
		//Object Value：我们要操作的数据
		//数据存储的位置：看express是否使用#，如果使用了#，操作的就是contextMap，如果不是，操作的就是valueSt
		//
		vs.setValue("#name","张三");
		vs.setValue("name","lisi");
		//set(String key,Object o)
		//String key:Map的key
		//Object o:map的value
		//如果栈顶是一个Map元素，直接把key作为map的key(是值部分),把object作为map的value存入，存入的是栈顶
		//如果，栈顶不是一个map元素，创建一个map元素，，直接把key作为map的key,把object作为map的value存入，压如栈顶
		vs.set("s1", new Student("王五",18));
		vs.push(new Student("test",23));
		vs.set("s2", new Student("aaa",28));
	
		return SUCCESS;
	}
	//
	
}
