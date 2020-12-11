package com.dgw.book.controller;
import com.dgw.book.entity.PageBean;
import com.dgw.book.entity.PageRequest;
import com.dgw.book.service.SelectService;
import com.dgw.book.service.impl.SelectServiceImpl;
import com.dgw.book.utils.DbFormat;
import com.dgw.book.utils.Send;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 分页查询接口
 */

@WebServlet("/page")
public class SelectController extends HttpServlet {

 SelectService selectService = new SelectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PageBean<PageRequest> pageRequest = selectService.pageBook();
        System.out.println(pageRequest);
        Send<PageBean<PageRequest>> integerSend = null;
        if(pageRequest!=null){
            //成功
            integerSend = Send.sendJsonSucess(pageRequest);
            DbFormat.format(resp, integerSend);
            System.out.println("分页查询成功成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("分页查询成功失败");

        }

    }
}
