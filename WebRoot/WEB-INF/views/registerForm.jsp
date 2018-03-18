<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'registerForm.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<!-- 
  	需要注意的是，这里form标签中并没有设置action属性。在这种情况下，当表单提交时，
  	它会提交到与展现时相同的URL路径上。也就是说，它会提交到"/spitter/register"上。
  	 -->
    <form method="post">
    	First Name:<input type="text" name="firstName"/><br/>
    	Last Name:<input type="text" name="lastName"/><br/>
    	Username:<input type="text" name="username"/><br/>
    	Password:<input type="text" name="passWord"/><br/>
    	<input type="submit" name="Register"/><br/>
    </form>
  </body>
</html>
