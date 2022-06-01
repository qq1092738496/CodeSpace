package com.xad.web;

import com.sun.deploy.util.ArrayUtil;
import com.xad.pojo.User;
import com.xad.service.User_Function;
import com.xad.service.serviceImpl.User_functionImpl;
import sun.rmi.transport.DGCImpl_Skel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/5 11:19
 */
@WebServlet("/Register")
@MultipartConfig()
public class Register extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        User user = new User();
        if (
                req.getParameter("userName").matches("([a-zA-Z0-9]{4,12})?") &
                        req.getParameter("passWord").matches("([a-zA-Z0-9]{4,15})?") &
                        req.getParameter("Mailbox").matches("([a-zA-z0-9]+@[a-z0-9]{0,5}+\\.com)?") &
                        req.getParameter("nickName").matches("([a-zA-Z0-9\\S]{2,12})?") &
                        !"".equals(req.getParameter("Gander"))
        ) {
            user.setUserNumber(UUID.randomUUID().toString());
            user.setUserName(req.getParameter("userName"));
            user.setPassWord(req.getParameter("passWord"));
            user.setNickName(req.getParameter("nickName"));
            user.setMailbox(req.getParameter("Mailbox"));
            user.setGander(new Boolean(req.getParameter("Gander")));


            Part photo = req.getPart("Photo");
            InputStream inputStream = photo.getInputStream();
            byte[] bytes = new byte[(int) photo.getSize()];
            inputStream.read(bytes);
            user.setPhoto(bytes);
            User_Function user_function = new User_functionImpl();
            int register = user_function.Register(user);
            System.out.println(register);
            if (register == 1) {
                System.out.println("注册成功");
            } else if (register == 2) {
                System.out.println("账户名已存在");
            }
            inputStream.close();

        }else{
        }
    }
}
