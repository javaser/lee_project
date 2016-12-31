<%--
  Created by IntelliJ IDEA.
  User: Lee
  Date: 2016/12/29
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" 
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, inital-scale=1">
    <meta charset="UTF-8">
    <title>使用 Servlet3.0 实现文件上传</title>
  </head>
  <body>

  <fieldset>
    <legend>上传单个文件</legend>
    <%--文件上传时必须要设置表单的enctype="multipart/form-data"--%>
    <form action="${pageContext.request.contextPath}/uploadServlet"
          method="post" enctype="multipart/form-data">
      <input type="file" name="file"><br>
      <input type="submit" value="上传单个文件">
    </form>
  </fieldset>

  <hr>

  <fieldset>
    <legend>上传多个文件</legend>
    <form action="${pageContext.request.contextPath}/uploadServlet"
          method="post" enctype="multipart/form-data">
      上传文件：<input type="file" name="file1"><br>
      上传文件：<input type="file" name="file2"><br>
      <input type="submit" value="上传多个文件">
    </form>
  </fieldset>
    
  </body>
</html>
