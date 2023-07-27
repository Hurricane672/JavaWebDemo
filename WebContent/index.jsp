<%--
  Created by IntelliJ IDEA.
  User: 672
  Date: 2023/4/17
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>LOGIN</title>
</head>
<body>
<center>
  <form action="${pageContext.request.contextPath}/login" method="get">
    <br>
    <label>
      Username:
      <input type="text" name="username">
    </label><br><br>
    <label>
      Password:
      <input type="password" name="password">
    </label><br><br>
    <input type="submit" value="submit" >
  </form>
</center>
</body>
</html>
