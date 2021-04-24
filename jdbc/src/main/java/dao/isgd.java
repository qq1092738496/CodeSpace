package dao;

import pojo.grade;

import java.sql.SQLException;
import java.util.List;

public interface isgd {
    //增
    public int insert(grade grade) throws SQLException;
    //删
    public int delete(int id) throws SQLException;
    //改
    public int update(grade grade) throws SQLException;
    //查
    public List<grade> select () throws SQLException;


}
