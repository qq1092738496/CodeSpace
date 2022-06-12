package servlet;

import service.business;
import service.businessImpl;

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
 * @time: 2022/6/11 12:20
 */
@WebServlet("/zhmima")
public class zhmima extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("userName").matches("([a-zA-Z0-9]{6,12})?") &
                req.getParameter("passWord").matches("([a-zA-Z0-9]{6,15})?") &
                req.getParameter("Mailbox").matches("([a-zA-z0-9]+@[a-z0-9]{0,5}+\\.com)?")) {
            HashMap<String, String> userMap = new HashMap<>();
            String userName = req.getParameter("userName");
            String passWord = req.getParameter("passWord");
            String mailbox = req.getParameter("Mailbox");
            business business = new businessImpl();
            int i = business.Retrieve_passWord(userName,passWord,mailbox);
            if (i == 1) {
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
                System.out.println("瀵嗙爜璁剧疆鎴愬姛");
            } else {
                resp.sendRedirect("/blog/zhmima.jsp.jsp");
                System.out.println("璐﹀彿閭鏈夎鎴栦笉瀛樺湪");
            }
        } else {
            resp.sendRedirect("/blog/zhmima.jsp.jsp");
            System.out.println("杈撳叆鐨勬牸寮忔湁璇�");
        }
    }
}
