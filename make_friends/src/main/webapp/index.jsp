<%@ page import="com.xad.pojo.News" %>
<%@ page import="com.xad.pojo.User" %>
<%@ page import="com.xad.pojo.UserPage" %>
<%@ page import="java.util.LinkedList" %>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="index.css" charset="utf-8">
<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <title>交友</title>
</head>
<body>
<header id="header">

    <div class="container-inner">
        <div class="group pad">
            <h1>
                校园交友
            </h1>
            <p class="site-description">嘿嘿嘿</p>
        </div>
    </div>
</header>
<% UserPage userPage = (UserPage) request.getAttribute("userPage");
    User thisUser = (User) request.getAttribute("thisUser");
    LinkedList<News> thisNews = (LinkedList<News>) request.getAttribute("thisNews");
    LinkedList<User> userAll = userPage.getLimitUser();
    //在搜索后， 防止页面跳转回来
    String userName = "";
    if (null != request.getAttribute("userName")) {
        userName = "&userName=" + request.getAttribute("userName").toString();
    }
    /*boolean jurisdiction = false;
    String a = "readonly";
    if (request.getServletContext().getAttribute("userName").equals("admin")) {
        jurisdiction = true;
        a = "";
    }*/

%>
<table id="table" rules=rows
       style=" z-index: 1; width: 1018px; height: 200px; margin: -54px 0% 0% 238px;  background-color: #FFFFFF;">
    <tr>
        <td class="userNews" style=" background-color: #F0F0F0; width: 30%; height: 51px;">个人信息</td>
        <td id="" style="  width: 70%; height: 51px;">
            <form action="/api/Current_User" method="get">
                <input type="text" name="userName"/>
                <input type="submit" value="搜索用户"/>
            </form>
        </td>
    </tr>
    <tr class="">
        <td rowspan="<%=userPage.getLimitUser().size()+1%>" style="background-color: #F0F0F0; ">
            <div>

            </div>
            <div>
                <li>昵称：<%=thisUser.getNickName()%>
                </li>
                <li>
                    账号:<%= thisUser.getUserName()%>
                </li>
                <li>微信:<%=thisUser.getWeChat()%>
                </li>
                <li>性别：<%=thisUser.getGander()%>
                </li>
                <li>爱好：<%=thisUser.getHobby()%>
                </li>
                <li>个人简介：<%=thisUser.getBrief_Introduction()%>
                </li>
            </div>

        </td>
        <td>
            <div style="">
                <%
                    for (News thisNew : thisNews) {
                        out.print("发送人:<a href=\"#\" id = \"" + thisNew.getSender() + "\" onclick=\"bb(this)\">" +
                                thisNew.getSender() +
                                "</a>");

                        out.print("内容:" + thisNew.getContent());

                        out.print("接受人<a href=\"#\" id = \"" + thisNew.getReceiver() + "\" onclick=\"bb(this)\">" +
                                thisNew.getReceiver() +
                                "</a>");
                        out.print("<a href=deletNews?newsNumber=" + thisNew.getnewsNumber() + "&Sort_Id=" +
                                thisNew.getSort_Id() +userName+ ">删除</a><br>");
                    }
                %>
            </div>
            <div>

                <textarea id="sadas"></textarea>
                <button onclick="aa()">发表</button>
            </div>
        </td>
    </tr>
    <% for (User user : userAll) {%>
    <tr class="data">
        <td>
            <div>
                <div>
                    <img width="100px" height="100px" src="/api/UserImg?userName=<%= user.getUserName()%>"/>


                    昵称：<%=user.getNickName()%>
                    <div>
                        昵称：<%=user.getNickName()%>
                        账号:<%= user.getUserName()%>
                        微信:<%=user.getWeChat()%>

                        性别：<%=user.getGander()%>

                        爱好：<%=user.getHobby()%>
                    </div>
                </div>
                <div>
                    个人简介：<textarea id="<%=
                    user.getUserName()%> <%--<%=a %>--%>    "><%=user.getBrief_Introduction()%>
                </textarea>
                    <%--<% if (jurisdiction) {
                        out.print("<button onclick=\"updata("+user.getUserName()+")\">修改</button>");
                    }%>--%>
                </div>
                <div>
                    <iframe width="100%" height="100%" scrolling="no" frameborder="no"
                            src="News?userNumber=<%=user.getUserNumber()%>&userName=<%=user.getUserName()%>"></iframe>
                </div>
            </div>
        </td>

    </tr>
    <%} %>
    <tr>
        <td colspan="2">当前页数:<%= userPage.getThisPage()%>/总页数:<%= userPage.getTotalPage()%> 每页显示<%=
        userPage.getPageSize()%>
            总数据:<%=userPage.getTotalUser()%>
            <a href="Current_User?thispage=1">首页</a>
            <a href="Current_User?thispage=<%=userPage.getThisPage() == 1? 1 : userPage.getThisPage()-1%><%= userName%>">上一页</a>
            <a href="Current_User?thispage=<%=userPage.getThisPage() == userPage.getTotalPage()?
                    userPage.getTotalPage() :
                    userPage.getThisPage()+1%><%= userName%>">下一页
            </a></td>
    </tr>

</table>
<script>
    var newsNumber = "newsNumber=<%= thisUser.getUserNumber()%>";
    var Sender = "Sender=<%= thisUser.getUserName()%>";
    var Content = "";
    var Receiver = "Receiver=<%= thisUser.getUserName()%>";

    function updata(value) {
        console.log(value)
    }

    function bb(value) {
        Receiver = "Receiver=" + value.getAttribute("id");
        document.getElementById("sadas").placeholder = '回复：' + value.getAttribute("id");
        console.log(newsNumber + "&" + Sender + "&" + Content + "&" + Receiver);
    }

    function aa() {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                }

            }
        }

        Content = "Content=" + document.getElementById("sadas").value;
        xhr.open('POST', "http://localhost:8080/api/User_News", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send(newsNumber + "&" + Sender + "&" + Content + "&" + Receiver);
        console.log(newsNumber + "&" + Sender + "&" + Content + "&" + Receiver);
        document.getElementById("sadas").value = "";
        location.reload();
    }

</script>
</body>
</html>
