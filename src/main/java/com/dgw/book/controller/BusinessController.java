package com.dgw.book.controller;
import com.dgw.book.entity.BookLend;
import com.dgw.book.entity.BookLendItem;
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
 *   功能实现
 * 1,书本借出业务(修改数量(库存表),查询更新数据(库存表),记录借书记录(借书表,借出时间),返回数据,)
 *
 */
@WebServlet("/business")
public class BusinessController extends HttpServlet {
    BookLendItemService bookLendItemService = new BookLendItemServiceImpl();


    //借书
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");
        String bookName = req.getParameter("bookName");
        int bookIds = Integer.parseInt(bookId);
        BookLendItem bookLendItem = new BookLendItem(bookIds,bookName);
        //Service操作
        List<BookLend> bookLends = bookLendItemService.updateBook(bookLendItem);
        Send<List<BookLend>> integerSend = null;
        if(bookLends!=null){
            //成功
            integerSend = Send.sendJsonSucess(bookLends);
            DbFormat.format(resp, integerSend);
            System.out.println("借书成功");
        }else{
            //失败
            integerSend = Send.sendJsonError(null);
            DbFormat.format(resp, integerSend);
            System.out.println("借书失败");

        }

    }

}
