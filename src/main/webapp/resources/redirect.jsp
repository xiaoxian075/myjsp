<!-- jsp页面重定向 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsp页面重定向</title>
</head>
<body>
	<h1>页面重定向</h1>
	<%
	   // 重定向到新地址
	   String site = new String("http://www.runoob.com");
	   response.setStatus(response.SC_MOVED_TEMPORARILY);
	   response.setHeader("Location", site); 
	%>
</body>
</html>