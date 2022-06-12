<%--
  Created by IntelliJ IDEA.
  User: Quiet
  Date: 2022/6/11
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <style>
        body{
            /* 设置背景渐变 */
            background-image: linear-gradient(to left,
            #9c88ff,#3cadeb);
            display: flex;
            justify-content: center;
        }
        .a{
            position:relative;
            top: 100px;
            width: 1100px;
            height: 550px;
            box-shadow: 0 5px 15px rgba(0,0,0,.8);
            display: flex;
        }
        .b{
            width: 800px;
            height: 700px;
            background-image: url("images/tx.jpg");
            /* 让图片适应大小 */
            background-size: cover;
        }
        .c{
            width: 300px;
            height: 700px;
            background-color: white;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .d{
            width: 250px;
            height: 650px;
        }
        .d img{
            width: 150px;
            height: 90px;
        }
        .d h1{
            font: 900 30px '';
        }
        .e{
            width: 230px;
            margin: 20px 0;
            outline: none;
            border: 0;
            padding: 10px;
            border-bottom: 3px solid rgb(80,80,170);
            font: 900 16px '';
        }
        .f{
            float: right;
            margin: 10px 0;
        }
        .m{
            float: left;
            margin: 10px 0;

        }
        .g{
            position: absolute;
            margin: 20px;
            bottom: -50px;
            display: block;
            width: 200px;
            height: 60px;
            font: 900 30px '';
            text-decoration: none;
            line-height: 50px;
            border-radius: 30px;
            background-image: linear-gradient(to left,
            #9c88ff,#3cadeb);
            text-align: center;
        }
    </style>
</head>
<body>
<div class="a">
    <div class="b"></div>
    <div class="c">
        <div class="d">
            <h1>注册账号</h1>
            <input type="text" class="e" placeholder="账号">
            <input type="text" class="e" placeholder="密码">
            <input type="password" class="e" placeholder="确认密码">
            <input type="peng" class="e" placeholder="邮箱">
            <!-- <img  src="img/yzm.png"/> -->
            <a href="index.jsp" class="m">已有账号</a>


            <a href="#" class="g">确定注册</a>
        </div>
    </div>
</div>
</body>
</html>