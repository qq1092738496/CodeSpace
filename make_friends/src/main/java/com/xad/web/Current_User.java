package com.xad.web;
import com.xad.pojo.User;
import com.xad.pojo.UserPage;
import com.xad.service.Display_Data;
import com.xad.service.User_Function;
import com.xad.service.serviceImpl.Display_DataImpl;
import com.xad.service.serviceImpl.User_functionImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;




import com.xad.pojo.News;
import com.xad.pojo.News;

/**
 * @description:
 * @author: Andy
 * @time: 2022/5/5 19:38
 */
@WebServlet("/Current_User")
public class Current_User extends HttpServlet {
    User_Function user_function = new User_functionImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //userName 代表搜索框的值,如果不是搜索就走dopost
        String userName = req.getParameter("userName");
        System.out.println("````````````````"+userName+"``````````````````````");
        if (userName != null) {
            Integer login = Integer.valueOf(req.getServletContext().getAttribute("login").toString());
            if (login == 1) {
                String userName2 = req.getServletContext().getAttribute("userName").toString();
                User thisUser = user_function.User_Information(userName2);
                LinkedList<News> thisNews = user_function.News_Information(thisUser.getUserNumber());
                req.setAttribute("thisNews", thisNews);
                req.setAttribute("thisUser", thisUser);

                Integer thispage = 1;
                Integer pagesize = 6;
                if (null != req.getParameter("thispage")) {
                    thispage = Integer.valueOf(req.getParameter("thispage"));
                }

                UserPage userPage = user_function.likeUser(userName, thispage, pagesize);
                req.setAttribute("userName",userName);
                req.setAttribute("userPage", userPage);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } else {
            doPost(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Display_Data display_data = new Display_DataImpl();
        Integer login = Integer.valueOf(req.getServletContext().getAttribute("login").toString());      //暂时用login代替

        if (login == 1) {
            String userName = req.getServletContext().getAttribute("userName").toString();
            User thisUser = user_function.User_Information(userName);
            LinkedList<News> thisNews = user_function.News_Information(thisUser.getUserNumber());
            req.setAttribute("thisNews", thisNews);
            req.setAttribute("thisUser", thisUser);

            Integer thispage = 1;
            Integer pagesize = 6;
            if (null != req.getParameter("thispage")) {
                thispage = Integer.valueOf(req.getParameter("thispage"));
            }
            UserPage userPage = display_data.All_User_Information(thisUser.getUserName(), thispage, pagesize);
            req.setAttribute("userPage", userPage);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
