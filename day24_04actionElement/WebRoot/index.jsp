<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
  <%--创建动作类方式：
  <a href="${pageContext.request.contextPath}/action2.action">1</a>
   <a href="${pageContext.request.contextPath}/action3.action">2</a>
   <a href="${pageContext.request.contextPath}/action4.action">3</a>
   <a href="${pageContext.request.contextPath}/defaultAction.action">defaultAction</a>
   --%>
   
   <%--通过通配符的方式访问动作类和动作方法 --%>
   <a href="${pageContext.request.contextPath}/add_User.action">add_User</a>
   <a href="${pageContext.request.contextPath}/update_User.action">update_User</a>
   <a href="${pageContext.request.contextPath}/delete_User.action">delete_User</a>
   <a href="${pageContext.request.contextPath}/find_User.action">find_User</a>
   <br/>
   <%--通过动态方法调用的配置
   		方式一：动作名称！动作方法
   		方式二：动作名称！动作方法.action
    --%>
   <a href="${pageContext.request.contextPath}/user!addUser">add_User</a>
   <a href="${pageContext.request.contextPath}/user!updateUser.action">update_User</a>
   <a href="${pageContext.request.contextPath}/user!deleteUser.action">delete_User</a>
   <a href="${pageContext.request.contextPath}/user!findUser">find_User</a>
  </body>
</html>
