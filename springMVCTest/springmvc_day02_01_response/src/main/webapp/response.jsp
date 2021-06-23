<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/1
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                alert("hello btn");
            });
        });
    </script>
</head>
<body>

    <a href="user/testString" >testString</a>

    <br/>

    <a href="user/testVoid" >testVoid</a>

    <br/>

    <a href="user/testModelAndView" >testModelAndView</a>

    <br/>

    <a href="user/testForwardOrRedirect" >testForwardOrRedirect</a>

    <br/>

    <button id="btn">发送ajax的请求</button>

</body>
</html>
