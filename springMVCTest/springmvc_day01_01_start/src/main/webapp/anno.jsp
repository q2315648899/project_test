<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--常用的注解--%>
    <!-- requestParams 注解的使用 -->
    <a href="anno/testRequestParam?name=哈哈">RequestParam</a>

    <br>
    <!-- request body 注解 -->
    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username" /><br/>
        用户年龄：<input type="text" name="age" /><br/>
        <input type="submit" value="提交" />
    </form>

    <!-- PathVariable 注解 -->
    <a href="anno/testPathVariable/10">testPathVariable</a>

    <br>
    <!-- RequestHeader 注解 -->
    <a href="anno/testRequestHeader">RequestHeader</a>

    <br>
    <!-- CookieValue 注解 -->
    <a href="anno/testCookieValue">CookieValue</a>

</body>
</html>
