<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <a href="${pageContext.request.contextPath}}/hello.action">以。action结尾</a>
      <a href="${pageContext.request.contextPath}}/hello">不已。action结尾</a>
        <a href="${pageContext.request.contextPath}}/hello.do">以。do结尾</a>
          <a href="${pageContext.request.contextPath}}/hello">不以。do结尾</a>
          <a href="${pageContext.request.contextPath}}/hello.abc">以。abc结尾</a>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      </body>
</html>
