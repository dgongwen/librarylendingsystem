package com.dgw.book.controller;
import com.dgw.book.entity.BookReturn;
import com.dgw.book.service.BookLendItemService;
import com.dgw.book.service.impl.BookLendItemServiceImpl;
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
 * 本归还业务(修改数量(库存表),查询更新数据(库存表))
 */

@WebServlet("/return")
public class ReturnController extends HttpServlet {
BookLendItemService bookLendItemService = new BookLendItemServiceImpl();
    //归还
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("returnBookName");
        int bookIds = Integer.parseInt(bookId);
        BookReturn bookReturn = new BookReturn(bookIds,bookName);
        List<BookReturn> bookReturns = bookLendItemService.returnBook(bookReturn);
        Send<List<BookReturn>> integerSend = null;
        if(bookReturns!=null){
            //成功
            integerSend = Send.sendJsonSucess(bookReturns);
            DbFormat.format(resp, integerSend);
            System.out.println("还书成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("还书失败");

        }
    }
}
