<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--使用s:property标签，获取valueStack中的元素
	value属性的取值是一个oGNL表达式。它只能获取元素的属性
	注意：去valueStack中对象属性时，不适用#
	它是从栈顶逐个对象查找指定的属性名称，只要没找到，就会一直往下找
 --%>
 <%--获取valueStack中指定位置的属性：使用的是【索引】。属性名称 --%>
 0-name <s:property value="[0].name" /><br/>
   1-name <s:property value="[1].name" /><br/>
   2-name <s:property value="[2].name" /><br/>
   3-name <s:property value="[3].name" /><br/>
   4-name <s:property value="[4].name" /><br/>
   <%--当s:peroperty什么都不写，默认去栈顶元素 --%>
   <s:property />
 <s:debug />
</body>
</html>