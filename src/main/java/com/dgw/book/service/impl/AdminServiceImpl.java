package com.dgw.book.service.impl;
import com.dgw.book.dao.AdminDao;
import com.dgw.book.dao.impl.AdminDaoImpl;
import com.dgw.book.entity.Admin;
import com.dgw.book.service.AdminService;
import java.util.List;

public class AdminServiceImpl implements AdminService {

   private   AdminDao adminDao = new AdminDaoImpl();
    //注册
    @Override
    public int aegisterAdmin(Admin admin) {
        int i = 0;
        //查询用户是否存在
        List<Admin> admins = adminDao.selectName();
        for(Admin admin1 :admins){
            if(admin1.getName().equals(admin.getName())){
                return 0;

            }else{
                //用户不存在,添加新用户
                i = adminDao.addAdmin(admin);
            }
        }
        return i;
    }

    //登录
    @Override
    public boolean adminLogin(Admin admin) {
        List<Admin> admins = adminDao.userLogin();
        for(Admin admin2 :admins){
            //用户名,密码一致
            if(admin2.getName().equals(admin.getName())&&admin2.getPassword().equals(admin.getPassword())){
                return true;
            }
        }
        return false;
    }
}
