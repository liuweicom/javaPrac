<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   动态方式一：数据模式和动作方法在一起
   <%--表单中的name属性取值必须和动作类中数据模型的set方法后面的名称一致。 --%>
   <form action="${pageContext.request.contextPath}/action2" method="post">
   用户名：<input name="username" type="text"/><br/>
   年龄：<input name="age" type="text"/><br/>
   	<input type="submit" value="提交">
   </form>
 动态方式二：数据模式和动作方法不在一块<br/>
 <form action="${pageContext.request.contextPath}/action3" method="post">
   用户名：<input name="user.username" type="text"/><br/>
   年龄：<input name="user.age" type="text"/><br/>
   	<input type="submit" value="提交">
   </form>
 动态方式三：实现modelDriven形式<br/>
 <form action="${pageContext.request.contextPath}/action4" method="post">
   用户名：<input name="username" type="text"/><br/>
   年龄：<input name="age" type="text"/><br/>
   	<input type="submit" value="提交">
   </form>
  </body>
</html>
