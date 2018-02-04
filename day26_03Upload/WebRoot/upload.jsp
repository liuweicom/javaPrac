<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%-- 文件上传的必要前提：
  		1.请求方式必须是POST
  		2.encype属性必须是multipart/form-data
  		3.提供一个文件选择域 --%>
    <s:actionerror/>
    <s:form action="upload.action" enctype="multipart/form-data">
    	<s:textfield name="username" label="用户名"/>
    	<s:file name="photo" label="照片"/>
    	<s:file name="photo" label="照片"/>
    	<s:submit value="上传"/>
    	
    	
    	
    	
    	
    	
    </s:form>
  </body>
</html>
