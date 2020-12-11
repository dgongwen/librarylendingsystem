package com.dgw.book.controller;
import com.dgw.book.entity.BookInformation;
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
import java.util.List;

/**
 * 展示所有商品信息接口
 */

@WebServlet("/selectAll")
public class SelectAllController extends HttpServlet {
    SelectService selectService = new SelectServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookInformation> bookInformations = selectService.selectBook();
        Send<List<BookInformation>> integerSend = null;
        if(bookInformations!=null){
            //成功
            integerSend = Send.sendJsonSucess(bookInformations);
            DbFormat.format(resp, integerSend);
            System.out.println("获取成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("获取失败");

        }
    }
}
