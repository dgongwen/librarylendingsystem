package com.dgw.book.service;
import com.dgw.book.entity.BookLend;
import com.dgw.book.entity.BookLendItem;
import com.dgw.book.entity.BookReturn;
import java.util.List;

public interface BookLendItemService {

    //借书
    List<BookLend> updateBook(BookLendItem bookLendItem);

    //还书
    List<BookReturn> returnBook(BookReturn bookReturn);
}
