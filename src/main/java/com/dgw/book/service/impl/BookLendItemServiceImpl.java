package com.dgw.book.service.impl;
import com.dgw.book.dao.BookLendItemDao;
import com.dgw.book.dao.impl.BookLendItemDaoImpl;
import com.dgw.book.entity.BookLend;
import com.dgw.book.entity.BookLendItem;
import com.dgw.book.entity.BookReturn;
import com.dgw.book.service.BookLendItemService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookLendItemServiceImpl implements BookLendItemService {
    BookLendItemDao bookLendItemDao = new BookLendItemDaoImpl();

    //借书
    @Override
    public List<BookLend> updateBook(BookLendItem bookLendItem) {
        int i = 0;
        int i1 = 0;
        List<BookLend> bookLends = null;
        //获取当前时间,设置当前时间=借出时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        //借书成功修改书本库存数量
         i = bookLendItemDao.regularScript(bookLendItem);
        //记录借书信息,存储借书信息
        BookLend bookLend = new BookLend();
        //记录借出书名
        bookLend.setBookLendName(bookLendItem.getBookName());
        //记录借出时间
        bookLend.setLendTime(dateFormat.format(date));
        //记录还书时间
        bookLend.setReturnTime(dateFormat.format(new Date(date.getTime() + 10 * 24 * 60 * 60 * 1000)));
        //添加借书记录
         i1 = bookLendItemDao.insertLendBook(bookLend);
        //判断数据是否(更改)和(添加)成功,成功直接讲借书信息发送
         if(i>0&&i1>0){
             //查出更新的借书信息
              bookLends = bookLendItemDao.selectBookLend();
         }else{
             System.out.println("借书失败");
             return null;

         }
        return bookLends;
    }

    //还书
    @Override
    public List<BookReturn> returnBook(BookReturn bookReturn) {
        List<BookReturn> bookReturns = null;
        int i = 0;
        int i1 =0;
         i = bookLendItemDao.updateReturnBook(bookReturn);
        //获取当前时间,设置当前时间=借出时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        BookReturn Return = new BookReturn();
        //保存还书信息
        Return.setBookId(bookReturn.getBookId());
        //保存还书书名
        Return.setReturnBookName(bookReturn.getReturnBookName());
        //保存还书时间
        Return.setReturnTime(dateFormat.format(date));
        //添加还书信息
         i1 = bookLendItemDao.insertBookReturn(Return);
        if(i>0&&i1>0){
            //查出更新数据,提示成功
            bookReturns = bookLendItemDao.selectReturn();
        }else{
            System.out.println("归还失败");
            return null;
        }
        return bookReturns;
    }
}
