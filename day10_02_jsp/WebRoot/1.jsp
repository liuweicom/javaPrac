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
<!--HTML��ע�ͷ���������Ч�ʵͣ�������  -->
<%--jsp��ע�ͷ�����Ч�ʸߣ��ͺ����� --%>


<%--
jsp��3��ָ�
<%@ ָ������ ����һ=������ֵ1��%>
page:���ڶ���jspҳ��ĸ�������
1.1�� import ��java�����е�import��һ����
<%@ page import="java.util.Date,java.util.List"%>
���ߣ�
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
JSP���Զ��������µİ���
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
1.2�� session: �Ƿ���Զ�����session����Ĭ��ֵ��true;
1.3�� buffer: JSP����javax.servlet.jsp.JspWriter����ַ��������á�������ݵĻ����С��Ĭ����8kb.
1.4 errorPage: ���ҳ�����д�������ת��ָ������Դ��
errorPage="/uri" ���д��/�������ǰӦ�õ�Ŀ¼�£�����·����
�����д��/����������·����
    1.5�� isErrorPage: �Ƿ񴴽�throwable����Ĭ����false;
1.6�� contextType: ��ͬ��response.setContextType("text/html;charset=utf-8");
1.7�� pageEncoding: ����JSP����Ҫ������ļ�ʹ�õı��롣
1.8�� isELIgnored: �Ƿ�֧��EL���ʽ�� Ĭ����false

<%@ page  pageEncoding="gbk" %>

include:��������Դ��������ǰҳ��
��̬�������ڷ���ʱ�������ļ��ϲ���һ���ļ�
<%@ include file="..."%>
��̬����������ϲ��ļ���������ִ��includeʱ���Ű�����һ���ļ�������
<jsp:include page="...."></jsp:include>
ԭ�����þ��ľͲ��ö���

taglib����jspҳ���е���jstl��ǩ�⡣�滻jsp�е�java����Ƭ��
<%@ taglib uri="--------" prefix="c">
 --%>
 <%--ȫ�ֱ����;�̬���д�� --%>
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