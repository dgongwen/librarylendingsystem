package com.dgw.book.controller;
import com.dgw.book.entity.BookInformation;
import com.dgw.book.service.SelectService;
import com.dgw.book.service.impl.SelectServiceImpl;
import com.dgw.book.utils.DbFormat;
import com.dgw.book.utils.Send;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 升序查询接口
 */

@WebServlet("/ascending")
public class AscendingController extends HttpServlet {

    SelectService selectService = new SelectServiceImpl();

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
       List<BookInformation> bookInformations = selectService.selectAscending();
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
