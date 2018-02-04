<%@page import="com.itheima.jsp.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--jsp的6个动作：
<jsp:include page="2.jsp"></jsp:include>
<jsp:include>动态包含
<jsp:forward>请求转发
<jsp:param>设置请求参数

<jsp:useBean>创建一个对象
<jsp:setProperty>给指定的对象属性赋值
<jsp:getProperty>取出指定对象的属性值

 --%>
 
 <%
  Student stu= new Student();
 stu.setName("tom");
 out.print(stu.getName());
  %>
  <jsp:useBean id="stu1" class="com.itheima.jsp.Student"></jsp:useBean>
  <jsp:setProperty property="name" name="stu1" value="jerry"/>
  <jsp:getProperty property="name" name="stu1"/>
  
  <!-- http://localhost:8080/day11_02_jsp2/6.jsp?name=123 -->
  <jsp:forward page="/5.jsp">
  	<jsp:param value="123" name="name"/>
  	<jsp:param value="333" name="pwd"/>
  </jsp:forward>
</body>
</html>