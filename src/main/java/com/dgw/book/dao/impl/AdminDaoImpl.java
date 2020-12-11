package com.dgw.book.dao.impl;
import com.dgw.book.dao.AdminDao;
import com.dgw.book.entity.Admin;
import com.dgw.book.utils.DbManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    //查询用户名是否存在
    @Override
    public List<Admin> selectName() {
        String sql = "select name from admin ";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            Statement statement1 = conn.createStatement();
            resultSet = statement1.executeQuery(sql);
            while (resultSet.next()){
                String name1 = resultSet.getString("name");
                Admin admin = new Admin(name1);
                list.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,statement,conn);
        }
        return list;
    }

    //添加用户
    @Override
    public int addAdmin(Admin admin) {
        String sql = "insert into admin(name,password,sex,age) value (?,?,?,?)";
        Connection conn = null;
        PreparedStatement prepared = null;
        int i = 0;
        try {
            conn = DbManager.getInstance().getConn();
            prepared = conn.prepareStatement(sql);
            prepared.setString(1,admin.getName());
            prepared.setString(2,admin.getPassword());
            prepared.setString(3,admin.getSex());
            prepared.setString(4,admin.getAge());
            i = prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close(prepared,conn);
        }
        return i;

    }

    //登录
    @Override
    public List<Admin> userLogin() {
        String sql = "select name,password from admin ";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            Statement statement1 = conn.createStatement();
            resultSet = statement1.executeQuery(sql);
            while (resultSet.next()){
                String name1 = resultSet.getString("name");
                String password = resultSet.getString("password");
                Admin admin = new Admin(name1,password);
                list.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,statement,conn);
        }
        return list;
    }
}
