<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
</head>
<body>
    <%--文件上传的话需要enctype="multipart/form-data"--%>
    <sf:form modelAttribute="user" method="post" enctype="multipart/form-data">
        用户名:<sf:input path="username"/><sf:errors path="username"/>
        <br>
        密码:<sf:input path="password"/><sf:errors path="password"/>
        <br>
        昵称:<sf:input path="nickname"/><sf:errors path="nickname"/>
        <br>
        <%--这里设置文件上传--%>
        文件:<input type="file" name="file">
        <input type="submit" value="提交">
    </sf:form>
</body>
</html>