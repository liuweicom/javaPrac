<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--jsp:的9个内置对象
request:
response:
session:
applicatin:
exception:
page:
config:
out:
pageContext:本身也是一个域对象，它可以操作其他三个域对象（request，session，application）
void setAttribute(String name,Object o);
Object getAttribute(String name);
void removeAttribute(String name);
操作其他域对象的方法：
void setAttribute(String name,Object o,int Scope);
Object getAttribute(String name,int Scopt);
void removeAttribute(String name,int Scope);
scpoe的值：
PageContext.PAGE_SCOPE 
PageContext.REQUEST_SCOPE 
PageContext.SESSION_SCOPE 
PageContext.APPLICATION_SCOPE

findAttribute(String name); 自动从page request session application依次查找，找到了就取值，结束查找。


 --%>
 <%
 	//pageContext.setAttribute("p","pp");
 	pageContext.setAttribute("p","pp",PageContext.PAGE_SCOPE);
 	
 	//pageContext.setAttribute("p", "pp",PageContext.REQUEST_SCOPE);
 	request.setAttribute("p", "request");
 	
 	//pageContext.setAttribute("p", "pp",PageContext.SESSION_SCOPE);
 	session.setAttribute("p", "session");
 	
 	//pageContext.setAttribute("p", "pp",PageContext.APPLICATION_SCOPE);
 	application.setAttribute("p", "application");
 	
 	//request.getRequestDispatcher("6.jsp").forward(request,response);
 	response.sendRedirect(request.getContextPath()+"/6.jsp");
 	pageContext.forward("6.jsp");
 	
 	
 	
 	
 	
 	
 	
 	
 	
  %>
</body>
</html>