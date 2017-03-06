<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, inital-scale=1">
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>

${errorInfo}
<form action="${path}/login" method="post">
    username: <input type="text" name="username"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>

</body>
</html>
