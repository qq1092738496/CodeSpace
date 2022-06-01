package com.xad.web;

import com.xad.pojo.News;
import com.xad.service.User_Function;
import com.xad.service.serviceImpl.User_functionImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/10 7:39
 */
@WebServlet("/User_News")
public class User_News extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("aa"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User_Function user_function = new User_functionImpl();
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        String newsNumber = req.getParameter("newsNumber");
        String sender = req.getParameter("Sender");
        String content = req.getParameter("Content");
        String receiver = req.getParameter("Receiver");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(new Date().getTime());
        News news = new News(newsNumber, sender, content, receiver,false,format);
        int i = user_function.User_News(news);
        if (i == 1){
            System.out.println("发送成功!");
            //req.getRequestDispatcher("/News").forward(req, resp);
        }
    }
}
