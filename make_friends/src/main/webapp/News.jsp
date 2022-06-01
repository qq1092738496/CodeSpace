<%@ page import="com.xad.pojo.News" %>
<%@ page import="com.xad.pojo.NewsPage" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Quiet
  Date: 2022/5/10
  Time: 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    NewsPage newsPage = (NewsPage) request.getAttribute("newsPage");
    LinkedList<News> newsAll = newsPage.getLimitNews();
    String newsNumber = request.getAttribute("userNumber").toString();
    String userName = request.getAttribute("userName").toString();
    /*boolean jurisdiction = false;
    if (request.getServletContext().getAttribute("userName").equals("admin")) {
        jurisdiction = true;
    }*/
%>
<%
    for (int i = 0; i < newsAll.size(); i++) {
        if (null != newsAll.get(i)) {
            out.print("发送人:<a href=\"#\" id = \"" + newsAll.get(i).getSender() + "\" onclick=\"bb(this)\">" +
                    newsAll.get(i).getSender() +
                    "</a>");
            out.print("内容:" + newsAll.get(i).getContent());
            out.print("接受人:<a href=\"#\" id = \"" + newsAll.get(i).getReceiver() + "\" onclick=\"bb(this)\">" +
                    newsAll.get(i).getReceiver() +
                    "</a><br>");
            out.print("时间:" + newsAll.get(i).getNews_Time() + "<br>");
           /* if (jurisdiction) {
                out.print("<a href=deletNews?newsNumber=" + newsAll.get(i).getnewsNumber() + "&Sort_Id=" +
                        newsAll.get(i).getSort_Id() + "&userName=" + userName + "&userNumber=" + newsAll.get(i).getnewsNumber() + ">删除</a><br>");

            }*/
        }
        if (i == newsAll.size() - 1) {
            Integer thispages = newsPage.getThisPage() == 1 ? 1 : newsPage.getThisPage() - 1;
            Integer thispagex = newsPage.getThisPage() >= newsPage.getTotalPage() ? newsPage.getTotalPage()
                    : newsPage.getThisPage() + 1;
            out.print("当前页数:" + newsPage.getThisPage() + "/");
            out.print("总页数:" + newsPage.getTotalPage());
            out.print("每页显示:" + newsPage.getPageSize());
            out.print("总数据:" + newsPage.getTotalNews());

            out.print("<a href=\"News?thispage=" + thispages + "&userNumber=" +
                    newsAll.get(i).getnewsNumber() + "&userName=" + userName +
                    "\">上一页</a>");
            out.print("<a href=\"News?thispage=" + thispagex + "&userNumber=" + newsAll.get(i).getnewsNumber() + "&userName=" + userName + "\">下一页</a>");
        }
    }
%>
<textarea id="data"></textarea>
<button type="submit" onclick="aa()" id="button">发送</button>
<script>
    var newsNumber = "newsNumber=<%= newsNumber%>"
    var Sender = "Sender=<%= request.getServletContext().getAttribute("userName")%>";
    var Content = "";
    var Receiver = "Receiver=<%= userName%>";

    function bb(value) {
        Receiver = "Receiver=" + value.getAttribute("id");
        document.getElementById("data").placeholder = '回复：' + value.getAttribute("id");
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

        Content = "Content=" + document.getElementById("data").value;
        xhr.open('POST', "http://localhost:8080/api/User_News", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send(newsNumber + "&" + Sender + "&" + Content + "&" + Receiver);
        document.getElementById("data").value = "";
        location.reload();
    }
</script>
</body>
</html>
