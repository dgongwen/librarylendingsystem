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
 * 范围查询接口
 */

@WebServlet("/condition")
public class ConditionServiceController extends HttpServlet {
    SelectService selectService = new SelectServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookPrice = req.getParameter("bookPrice");
        String bookLabel = req.getParameter("bookLabel");
        int bookPrices = Integer.parseInt(bookPrice);
        BookInformation bookInformation = new BookInformation(bookLabel,bookPrices);
        List<BookInformation> bookInformations = selectService.selectCondition(bookInformation);
        Send<List<BookInformation>> integerSend = null;
        if(bookInformations!=null){
            //成功
            integerSend = Send.sendJsonSucess(bookInformations);
            System.out.println(integerSend);
            DbFormat.format(resp, integerSend);
            System.out.println("查询成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("查询失败");

        }


    }
}
