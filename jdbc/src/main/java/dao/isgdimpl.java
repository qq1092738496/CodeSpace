package dao;

import pojo.grade;
import util.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class isgdimpl implements isgd{
    jdbc jdbc = new jdbc();
    Connection cont = jdbc.connt();
    Statement sta;

    {
        try {
            System.out.println(cont.createStatement());
            sta = cont.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //增
    @Override
    public int insert(grade grade) throws SQLException {
        String sql = "INSERT INTO stu (username,math,english,chinese) VALUES " +
                "("+"'"+grade.getUsername()+"',"+grade.getMath()+","+grade.getEnglish()+","+grade.getChinese()+")";
            int re = 0;
           re = sta.executeUpdate(sql);
            if (cont != null)cont.close();
            if (sta != null)sta.close();
        return re;
    }

    //删
    @Override
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM stu WHERE id="+id;
            int re = 0;
            re = sta.executeUpdate(sql);
            if (cont != null)cont.close();
             if (sta != null) sta.close();

        return re;
    }

    //改
    @Override
    public int update(grade grade) throws SQLException {
        int re = 0;
        String sql ="UPDATE stu SET"+" username='"+grade.getUsername()+"',math="+grade.getMath()+
                ",english="+grade.getEnglish()+",chinese="+grade.getChinese()+" WHERE "+ "id="+grade.getId();
        re = sta.executeUpdate(sql);
        if (cont != null)cont.close();
        if (sta != null)sta.close();
        return re;
    }
    //查
    @Override
    public ArrayList<grade> select() throws SQLException {
        String sql = "SELECT * FROM stu";
        
        ResultSet res = sta.executeQuery(sql);
        ArrayList<grade> list = new ArrayList<grade>();
        while (res.next()){
             grade grade = new grade();
             grade.setId(Integer.valueOf(res.getString("id").toString()));
             grade.setUsername(res.getString("username"));
             grade.setMath(Integer.valueOf(res.getString("math").toString()));
             grade.setEnglish(Integer.valueOf(res.getString("english").toString()));
             grade.setChinese(Integer.valueOf(res.getString("chinese").toString()));
             list.add(grade);
        }

        ResultSetMetaData metaData = res.getMetaData();
        metaData.getColumnType(3);

        /*ResultSetMetaData reda = res.getMetaData();
        int colu = reda.getColumnCount();
        System.out.println(colu);
        for (int i = 1;i<=colu ; i++){
            System.out.println(reda.getCatalogName(i));
        }*/
        if (res != null) res.close();
        if (cont != null)cont.close();
        if (sta != null)sta.close();
        return list;
    }
}
