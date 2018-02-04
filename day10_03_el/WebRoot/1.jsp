<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itheima.el.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--EL表达式：expression language表达式语言：它不是一种开发语言，是jsp中获取数据的一种规范 
	EL表达式：${u}原理：pageContext.findAttribute("u");
	El获取对于null这样的数据，在页面中表现为空字符串
	${u.name}===u.getName()方法，点（。）运算符相当于getter方法，点后米阿尼跟的是属性名
	==
	User u=(User)request.getAttribute("u");
	out.print(u.getName());
	[]运算符：点能干的，它也能，点不能干的，他能干
	${student.name}==${student['name']}==${student["name"]}
	
	
--%>
<%
	Student stu=new Student();
	stu.setName("tom");
	
	request.setAttribute("s",stu);
	request.getRequestDispatcher("2.jsp").forward(request,response);
	
 %>
 
 <%
 	List list=new ArrayList();
 	out.print(list.size());
 	list.add("aaa");
 	list.add("bbb");
 	list.add("cccc");
 	request.setAttribute("list", list);
  %>
  ${list[1]}<br/>
  <%
  	Map map=new HashMap();
  	map.put("a","aaa");
  	map.put("b","b");
  	map.put("c","cccc");
  	request.setAttribute("m",map);
   %>
   ${m.c}
</body>
</html>