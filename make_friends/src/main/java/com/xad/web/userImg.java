package com.xad.web;

import com.xad.pojo.User;
import com.xad.service.User_Function;
import com.xad.service.serviceImpl.User_functionImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/11 3:43
 */
@WebServlet("/UserImg")
public class userImg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        User_Function user_function = new User_functionImpl();
        String userName = req.getParameter("userName");

        User user = user_function.User_Information(userName);
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(user.getPhoto());
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
