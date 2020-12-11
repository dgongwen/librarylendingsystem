package com.dgw.book.controller;
import com.dgw.book.entity.Admin;
import com.dgw.book.service.AdminService;
import com.dgw.book.service.impl.AdminServiceImpl;
import com.dgw.book.utils.DbFormat;
import com.dgw.book.utils.Send;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *注册接口
 */

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String age = req.getParameter("age");
        Admin admin = new Admin(name,password,sex,age);
        //不为空添加
        int i = adminService.aegisterAdmin(admin);
        Send<Integer> integerSend = null;
        if(i>0){
            //成功
            integerSend = Send.sendJsonSucess(i);
            DbFormat.format(resp, integerSend);
            System.out.println("注册成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(i);
            DbFormat.format(resp, integerSend);
            System.out.println("注册失败");

        }
    }

}
