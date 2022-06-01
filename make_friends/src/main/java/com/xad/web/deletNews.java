package com.xad.web;

import com.xad.service.User_Function;
import com.xad.service.serviceImpl.User_functionImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/11 14:26
 */
@WebServlet("/deletNews")
public class deletNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newsNumber = req.getParameter("newsNumber");
        Integer sort_id = Integer.valueOf(req.getParameter("Sort_Id"));
        User_Function user_function = new User_functionImpl();
        int i = user_function.delet_News(newsNumber, sort_id);
        resp.sendRedirect("/api/Current_User");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
