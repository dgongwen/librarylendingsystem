package com.dgw.book.service;
import com.dgw.book.entity.Admin;

public interface AdminService {

    //注册
    int aegisterAdmin(Admin admin);

    //登录
    boolean adminLogin(Admin admin);
}
