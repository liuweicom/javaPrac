<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:debug/>
<%--使用s:property来获取ActionContext中的数据，
value属性的取值是valueStack中value对应的值，为一ognl表达式 --%>

<%--获取大Map中的数据，在取得时候#key --%>
<s:property value="#contextMap"/>
<%--获取大Map中小MAP中的数据，使用#大MAp的key.小map的key --%>
<s:property value="#session.sessionMap1"/>
<s:property value="#application.applicationMap"/>
</body>
</html>