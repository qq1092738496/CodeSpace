package servlet;

import pojo.user;
import service.business;
import service.businessImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: Andy
 * @time: 2022/6/11 12:20
 */
@WebServlet("/zhuc")
public class zhuc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        if (
                req.getParameter("userName").matches("([a-zA-Z0-9]{4,12})?") &
                        req.getParameter("passWord").matches("([a-zA-Z0-9]{4,15})?") &
                        req.getParameter("Mailbox").matches("([a-zA-z0-9]+@[a-z0-9]{0,5}+\\.com)?") &
                        !"".equals(req.getParameter("Gander"))
        ) {
            String userName = req.getParameter("userName");
            String passWord = req.getParameter("passWord");
            String mailbox = req.getParameter("Mailbox");

            business business = new businessImpl();
            int register = business.Register(userName, passWord, mailbox);
            if (register == 1) {
                req.getRequestDispatcher("/blog/index.jsp").forward(req, resp);
                System.out.println("×¢²á³É¹¦");
            } else if (register == 2) {
                resp.sendRedirect("/blog/zhuc.jsp");
                System.out.println("×¢²áÊ§°Ü");
            }


        }
    }
}
