<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="form.do" method="get" modelAttribute="user">
	<table>
		<tr>
			<td>Name:</td><td><form:input path="username"/></td>
		</tr>
		<tr>
			<td>Password:</td><td><form:password path="password"/></td>
		</tr>
		<tr>
			<td>Nickname:</td><td><form:input path="nickname"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"/></td>
		</tr>
	</table>  
</form:form>

</body>
</html>