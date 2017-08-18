<!-- 调用java类 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.myjsp.util.DateUtil"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Call Function</title>
</head>
<body>
	<%!
		int a=50;
		int b=41;
		int result=0; 
	%>
	<%
	//DateUtil util = new DateUtil();
	result=DateUtil.sub(a, b);                     //调用定义的方法
	System.out.println(result);
	%>
	<%=result %>
</body>
</html>