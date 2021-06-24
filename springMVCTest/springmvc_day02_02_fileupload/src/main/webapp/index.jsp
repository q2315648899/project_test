<%--
  Created by IntelliJ IDEA.
  User: wong
  Date: 2021/6/24
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>

    <form action="/user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传"/>
    </form>

</head>
<body>

</body>
</html>
