package com.xad.web;

import com.xad.service.User_Function;
import com.xad.service.serviceImpl.User_functionImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/5 14:20
 */
@WebServlet("/Retrieve_passWord")
public class Retrieve_passWord extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("userName").matches("([a-zA-Z0-9]{6,12})?") &
                req.getParameter("passWord").matches("([a-zA-Z0-9]{6,15})?") &
                req.getParameter("Mailbox").matches("([a-zA-z0-9]+@[a-z0-9]{0,5}+\\.com)?")) {
            HashMap<String, String> userMap = new HashMap<>();
            userMap.put("userName", req.getParameter("userName"));
            userMap.put("Mailbox", req.getParameter("Mailbox"));
            userMap.put("passWord", req.getParameter("passWord"));
            User_Function user_function = new User_functionImpl();
            int i = user_function.Retrieve_passWord(userMap);
            if (i == 1) {
                System.out.println("密码设置成功");
            } else {
                System.out.println("账号邮箱有误或不存在");
            }
        } else {
            System.out.println("输入的格式有误");
        }
    }
}
