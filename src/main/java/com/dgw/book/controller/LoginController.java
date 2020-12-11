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
 * 登录接口
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {

private AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Admin admin = new Admin(name,password);
        //逻辑处理
        boolean b = adminService.adminLogin(admin);
        Send<Integer> integerSend = null;
        if(b){
            //成功
            integerSend = Send.sendJsonSucess(null);
            DbFormat.format(resp, integerSend);
            System.out.println("登录成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("登录失败");

        }
    }
}
