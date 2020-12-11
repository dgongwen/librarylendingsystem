package com.dgw.book.controller;
import com.dgw.book.entity.BookCollect;
import com.dgw.book.service.CollectService;
import com.dgw.book.service.impl.CollectServiceImpl;
import com.dgw.book.utils.DbFormat;
import com.dgw.book.utils.Send;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 收藏夹功能接口
 */

@WebServlet("/collect")
public class CollectController extends HttpServlet {
CollectService collectService = new CollectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        int bookIds = Integer.parseInt(bookId);
        BookCollect bookCollect = new BookCollect(bookIds,bookName);
        int i = collectService.addCollect(bookCollect);
        Send<Integer> integerSend = null;
        if(i>0){
            //成功
            integerSend = Send.sendJsonSucess(i);
            DbFormat.format(resp, integerSend);
            System.out.println("收藏成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(i);
            DbFormat.format(resp, integerSend);
            System.out.println("收藏失败");

        }
    }
}
