package com.dgw.book.dao;
import com.dgw.book.entity.BookLend;
import com.dgw.book.entity.BookLendItem;
import com.dgw.book.entity.BookReturn;

import java.util.List;
public interface BookLendItemDao {

    //借出,修改库存数量
    int  regularScript(BookLendItem bookLendItem);

    //记录借书记录,保存数据
    int insertLendBook(BookLend bookLend);

    //查询借书更新数据
    List<BookLend> selectBookLend();

    //归还,修改库存数量
    int updateReturnBook(BookReturn bookReturn);

    //查询还书更新数据
    List<BookReturn> selectReturn();

    //记录还书记录,保存数据
    int insertBookReturn(BookReturn aReturn);
}
