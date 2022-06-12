<%--
  Created by IntelliJ IDEA.
  User: Quiet
  Date: 2022/6/11
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
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
            height: 500px;
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
            bottom: 0px;
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
        .p{
            text-align: center;
        }
    </style>
</head>
<script>
    //定义登录
    function chen(){

    }

</script>
<body>
<div class="a">
    <div class="b"></div>
    <div class="c">
        <div class="d">
            <h1>登录账号</h1>
            <form action="/blog/den" method="post">
            <input type="text" class="e" name="userName" placeholder="账号">
            <input type="text" class="e" name="passWord" placeholder="密码">
            <!-- <input type="password" class="e" placeholder="确认密码"> -->
            <a href="zhmima.jsp" class="m">找回密码</a>
            <a href="zhuc.jsp" class="f">注册</a>
                <input type="submit" value="确定登录" class="g">
            </form>
        </div>
    </div>
</div>

</body>
</html>
