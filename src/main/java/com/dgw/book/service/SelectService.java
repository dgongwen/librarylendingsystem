package com.dgw.book.service;
import com.dgw.book.entity.BookInformation;
import com.dgw.book.entity.PageBean;
import com.dgw.book.entity.PageRequest;
import java.util.List;

public interface SelectService {

    //分页展示
    PageBean<PageRequest> pageBook();

    //展示所有商品信息
    List<BookInformation> selectBook();

    //模糊查询
    List<BookInformation> selectLike(BookInformation bookInformation);

    //范围查询
    List<BookInformation> selectCondition(BookInformation bookInformation);

    //升序查询
    List<BookInformation>  selectAscending();
}
