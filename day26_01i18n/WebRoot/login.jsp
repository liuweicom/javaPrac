<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
Locale locale = request.getLocale();
ResourceBundle bundle = ResourceBundle.getBundle("com.itheima.resource.aa.message",locale);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <form action="">
    		<%=bundle.getString("jsp.login.username") %>：<input type="text" name="username"/><br/>
    	<% System.out.println(bundle.getString("jsp.login.username"));%>	
   	 	<%=bundle.getString("jsp.login.password") %>：<input type="password" name="password"/><br/>
   		<input type="submit" value="<%=bundle.getString("jsp.login.submit") %>" />
    </form>
  </body>
</html>
