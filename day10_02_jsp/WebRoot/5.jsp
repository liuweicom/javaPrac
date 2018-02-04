<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("name") %>
<%=request.getParameter("pwd") %>
<%=exception.getMessage() %>
<%--要想exception不报错,必须先设置page指令的属性 isErrorPage="true" 时才能使用--%>
服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
	服务器繁忙！
</body>
</html>