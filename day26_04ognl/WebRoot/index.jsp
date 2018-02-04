<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.itheima.com/function/myfunction" prefix="myfn"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
 
  <body>
     <%-- el表达式：${}
  		jsp表达式：<%= %>
  --%>
 <%--el表达式：只能调用静态方法 
 		abcdefg---->ABCDEFG
 --%>
 ${myfn:touppoercase("abcdef")}
 <hr/>
 <%--ognl表达式：它可以访问普通的方法
 			ognl表达式	必须写在struts2中的标签
 	s:property 它类似于jsp的表达式，把值输出到浏览器上
 	value:属性中的内容不再是我们看到的字符创，它是一个ognl表达式。要让它变成一个普通的字符串，需要在值得得外面套上单引号
 --%>
 <s:property value="OGNL-Expression"/>这是一个OGNl表达式<br/>
 <s:property value="'OGNL-Expression'"/>这是一个普通字符串<br/>
 <s:property value="'OGNL-Expression'.length()"/>使用普通字符串调用了获取长度的方法<br/>
 <%--ognl访问静态属性：访问静态属性的方式：@全类名@静态属性名称 --%>
 <s:property value="@java.lang.Integer@Max_VALUE"/><br/>
 <%--OGNL访问静态方法：
 		访问静态方法的方式：@全类名@静态方法
 		struts2的框架默认是禁用静态方法调用，我们可以通过配置开启
  --%>
   <s:property value="@java.lang.Math@random()"/><br/>
   <%--ognl操作map和List --%>
   <%--使用的是s:readio的标签，创建list集合
   {}就相当于创建一个list集合
   list 属性中的取值是一个ognl表达式 --%>
   <s:radio name="gender" list="{'男','女'}"></s:radio><br/>
   <%--使用s:radio创建一个map
   #{}表示创建一个map
   1和0作为value给radio标签的value属性赋值
   男和女作为key，显示到页面的内容 --%>
   <s:radio list="#{'1':'男','0':'女'}" name="gender"></s:radio>
  </body>
</html>
