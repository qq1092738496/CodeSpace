package com.xad.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xad.pojo.NewsPage;
import com.xad.service.Display_Data;
import com.xad.service.serviceImpl.Display_DataImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/10 3:41
 */

@WebServlet("/News")
public class News extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要通过该userNumber，单个查询
        String userNumber = req.getParameter("userNumber");
        //用来锁定搜索栏
        String userName = req.getParameter("userName");
        Integer indexes = 1;
        if (null !=req.getParameter("thispage")){
            indexes = Integer.valueOf(req.getParameter("thispage"));
        }
        Integer showdata = 2;
        Display_Data display_data = new Display_DataImpl(); NewsPage newsPage = display_data.All_User_News(userNumber
                , Integer.valueOf(indexes), showdata); req.setAttribute("userName",userName);
        //再传进去是因为 news中不包含userNumber，发送消息时，需要userNumber
        req.setAttribute("userNumber",userNumber);
        req.setAttribute("newsPage",newsPage);
        req.getRequestDispatcher("News.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
