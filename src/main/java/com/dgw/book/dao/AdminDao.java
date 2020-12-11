package com.dgw.book.dao;
import com.dgw.book.entity.Admin;
import java.util.List;

public interface AdminDao {
    //查询用户名
    List<Admin> selectName();

    //用户不存在,添加用户
    int addAdmin(Admin admin);

    //登录
    List<Admin> userLogin();
}
