<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--JSTL,jsp标准标签库，
	使用jstl,实现jsp页面中逻辑处理，
	使用jsp中tablib指令
	只用jstl标签
	
	通用标签，set out remove
	设置变量<c:set var="num" value="${10+5}" scope="page"></c:set>
	输出数据<c:out value="${num}"></c:out>
	移除变更<c:remove var="num"></c:remove>
	移除后输出<c:out value="${num}" default="aaaa">
	
	<c:set var="num" value="5"></c:set>
	<c:if test="${num>3}" >
		result:true
	</c:if>
	
	<c:choose>
		<c:when test="${num==1}">
			..
		</c:when>
		<c:when test="${num==2}">
			..
		</c:when>
		<c:when test="${num==3}">
			..
		</c:when>
		<c:otherwise>
			....
		</c:otherwise>
	</c:choose>
	普通循环
	<c:forEach var="i" begin="2" end="10" step="2">
	
	</c:forEach>
	迭代器：
	item中的写法必须是el格式，
	 c:forEach中的varStatus属性。
    	指向一个字符串，该字符串引用一个对象。  map.put("vs",一个对象);
    	这个对象记录着当前遍历的元素的一些信息：
    		getIndex():返回索引。从0开始
    		getCount():返回计数。从1开始
    		isLast():是否是最后一个元素
    		isFirst():是否是第一个元素
	<c:forEach item="${list}" var="l" varStatus="va">
		
	</c:forEach>
 --%>
 <%
 	List list=new ArrayList();
 	list.add("aaa");
 	list.add("bbbb");
 	list.add("ccc");
 	request.setAttribute("list",list);
  %>
  <c:forEach items="${list}" var="l">
  	${l }
  </c:forEach>
</body>
</html>