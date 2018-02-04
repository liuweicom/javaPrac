<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<%--empty 判断为空，空字符串和没有元素的集合（及时集合对象本身不为null）都返回true
 --%>

<%--<%
	Student stu =(Student) request.getAttribute("s");
	${s.name}
	%>
 --%> 
 
 <%
 	String str1=null;
 	request.setAttribute("str1", str1);
 	
 	String str2="";
 	request.setAttribute("str2", str2);
 	
 	String str3="abc";
 	request.setAttribute("str3", str3);
 	
 	List str4=new ArrayList();
 	request.setAttribute("str4", str4);
 	
 	List str5=new ArrayList();
 	str5.add("asdf");
 	request.setAttribute("str5", str5);
 	
 	int sex=0;
 	request.setAttribute("s",sex);
  %>
  ${empty str1 }----true<br/>
 ${empty str2 }----true<br/>
 ${empty str3 }----false<br/>
 ${empty str4 }----true<br/>
 ${empty str5 }----false<br/>
 
 ${empty list2?"你还没有买到商品":"你买的" }
 <input type="radio" name="sex" value="m" ${s==0 ? "checked='checked'":"" }/>男<br/>
<input type="radio" name="sex" value="f" ${s==1 ? "checked='checked'":"" }/>女<br/>
  
</body>
</html>