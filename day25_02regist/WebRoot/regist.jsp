<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册，使用到的Struts2的标签</title>
<s:head/>
</head>
<body>
<s:actionerror/><%--动作错误 --%>
<s:fielderror></s:fielderror><%--字段错误 --%>
<s:form action="register">
	<s:textfield name="username" label="用户名" requiredLabel="true" requirePosition="left"/>
	<s:password name="password" label="密码" showPassword="true"/>
	<s:textfield name="birthday" label="生日" />
	<s:submit value="提交"/>
</s:form>
</body>
</html>