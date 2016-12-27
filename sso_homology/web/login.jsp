<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2016/12/27
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, inital-scale=1">
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
    <center>
        <h1>请登录</h1>
        <form action="/sso/doLogin.action" method="post">
            <span>用户名：</span><input type="text" name="username"><br>
            <span>密码&nbsp;&nbsp;：</span><input type="password"
                                               name="password"><br>
            <input type="hidden" name="gotoUrl" value="${gotoUrl}">
            <input type="submit">
        </form>
    </center>
</body>
</html>
