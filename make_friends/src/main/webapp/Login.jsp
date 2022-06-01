<%--
  Created by IntelliJ IDEA.
  User: Quiet
  Date: 2022/5/10
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/api/Login" method="post">
    账号：<input type="text" name="userName"/>
    密码：<input type="text" name="passWord"/>
    <input type="submit" value="登入"/>
</form>
<form action="/api/Register" method="post" enctype="multipart/form-data">
    账号：<input type="text" name="userName"/>
    密码：<input type="text" name="passWord"/>
    昵称：<input type="text" name="nickName"/>
    邮箱：<input type="text" name="Mailbox"/>
    性别：男<input type="radio" checked="" name="Gander" value="true"/>
    女<input type="radio" name="Gander" value="flase"/>
    上传照片:<input type="file" name="Photo">
    <input type="submit" value="注册"/>
</form>

<form action="/api/Retrieve_passWord" method="post">
    账号：<input type="text" name="userName"/>
    邮箱：<input type="text" name="Mailbox"/>
    设置密码：<input type="text" name="passWord"/>
    <input type="submit" value="找回密码"/>
</form>
</body>
</html>
