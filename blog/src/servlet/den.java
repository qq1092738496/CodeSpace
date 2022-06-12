package servlet;

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
@WebServlet("/den")
public class den extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
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

            business business = new businessImpl();
            int login = business.Login(userName, passWord);
            req.getServletContext().setAttribute("login", login);
            if (login == 1) {
                req.getServletContext().setAttribute("userName", userName);
                req.getServletContext().setAttribute("passWord", passWord);
                req.getRequestDispatcher("/home.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("/blog/index.jsp");
                System.out.println("璐﹀彿鎴栧瘑鐮佹湁璇�");
            }
        } else {
            resp.sendRedirect("/blog/index.jsp");
            System.out.println("杈撳叆鐨勬牸寮忎笉姝ｇ‘");
        }
    }
}
