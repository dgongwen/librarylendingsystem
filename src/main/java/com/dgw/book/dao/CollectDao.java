package com.dgw.book.dao;
import com.dgw.book.entity.BookCollect;

public interface CollectDao {

    //收藏功能
    int addEnshrine(BookCollect bookCollect);

    //查询收藏记录
    BookCollect selectCollect(BookCollect bookCollect);
}
