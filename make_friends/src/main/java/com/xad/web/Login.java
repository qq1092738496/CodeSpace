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
 * @time: 2022/5/5 13:48
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        if (req.getParameter("userName").matches("([a-zA-Z0-9]{4,12})?") &
                req.getParameter("passWord").matches("([a-zA-Z0-9]{4,15})?")) {
            String userName = req.getParameter("userName");
            String passWord = req.getParameter("passWord");

            User_Function user_function = new User_functionImpl();
            int login = user_function.Login(userName, passWord);
            req.getServletContext().setAttribute("login", login);
            if (login == 1) {
                req.getServletContext().setAttribute("userName", userName);
                req.getRequestDispatcher("/Current_User").forward(req, resp);
            } else {
                System.out.println("账号或密码有误");
            }
        } else {
            System.out.println("输入的格式不正确");
        }
    }
}
