<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--HTML的注释方法：但是效率低，耗流量  -->
<%--jsp的注释方法，效率高，低耗流量 --%>


<%--
jsp的3个指令：
<%@ 指令名称 属性一=“属性值1”%>
page:用于定义jsp页面的各种属性
1.1、 import 和java代码中的import是一样的
<%@ page import="java.util.Date,java.util.List"%>
或者：
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
JSP会自动导入以下的包：
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
1.2、 session: 是否会自动创建session对象。默认值是true;
1.3、 buffer: JSP中有javax.servlet.jsp.JspWriter输出字符流。设置。输出数据的缓存大小，默认是8kb.
1.4 errorPage: 如果页面中有错误，则跳转到指定的资源。
errorPage="/uri" 如果写“/”则代表当前应用的目录下，绝对路径。
如果不写“/”则代表相对路径。
    1.5、 isErrorPage: 是否创建throwable对象。默认是false;
1.6、 contextType: 等同于response.setContextType("text/html;charset=utf-8");
1.7、 pageEncoding: 告诉JSP引擎要翻译的文件使用的编码。
1.8、 isELIgnored: 是否支持EL表达式。 默认是false

<%@ page  pageEncoding="gbk" %>

include:把其他资源包含到当前页面
静态包含：在翻译时把两个文件合并成一个文件
<%@ include file="..."%>
动态包含：不会合并文件，当代码执行include时，才包含另一个文件的内容
<jsp:include page="...."></jsp:include>
原则：能用静的就不用动的

taglib：在jsp页面中导入jstl标签库。替换jsp中的java代码片段
<%@ taglib uri="--------" prefix="c">
 --%>
 <%--全局变量和静态块的写法 --%>
 <%!
 int num=10;
 public void show(){
 }
  %>
  <%
  	int num2=10;
  	num++;
  	num2++;
  	out.print(num);
  	out.print(num2);
   %>
 <%
 Date dete;
 String s="";
 session.setAttribute("123","abcd");
  %> 
  2222222222222
  <%@include file="4.jsp" %>
	<%
	if(5>3){
	out.print(5);
	}
	 %>
	 <c:if test="${5>3} }">
	 aaaaaaaaaa
	 </c:if>