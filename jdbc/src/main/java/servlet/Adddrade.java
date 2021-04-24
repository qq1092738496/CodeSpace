package servlet;

import dao.isgd;
import dao.isgdimpl;
import pojo.grade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class Adddrade extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
        grade grade = new grade();
       String username = req.getParameter("username");
       String math = req.getParameter("math");
       String english = req.getParameter("english");
       String chinese = req.getParameter("chinese");
        System.out.println("获取数据成功");

        System.out.println(username + math +""+english +""+chinese);

       grade.setUsername(username);


            grade.setMath(Integer.valueOf(math));
            grade.setEnglish(Integer.valueOf(english));
            grade.setChinese(Integer.valueOf(chinese));





        isgd isgd = new isgdimpl();
        try {
            isgd.insert(grade);
            System.out.println("插入数据成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
