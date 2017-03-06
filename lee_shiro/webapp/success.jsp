<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, inital-scale=1">
    <meta charset="UTF-8">
    <title>success</title>
</head>
<body>
登录成功，欢迎你<shiro:principal/><br>
<br>
<h6>测试权限</h6>
<a href="${path}/admin">/admin</a>若有权限后台会打印<br>
<a href="${path}/student">/student</a>若有权限将404<br>
<a href="${path}/teacher">/teacher</a>若有权限将404<br>
</body>
</html>
