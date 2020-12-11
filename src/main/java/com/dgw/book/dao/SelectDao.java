package com.dgw.book.dao;
import com.dgw.book.entity.Admin;
import com.dgw.book.entity.BookInformation;
import com.dgw.book.entity.PageRequest;
import java.util.List;

public interface SelectDao {
    //查询用户所有信息
    List<Admin> showAdmin();

    //查询书籍所有信息
    List<PageRequest> selectPageList();

    //查询总条数
    int selectCount();

    //展示所有商品信息
    List<BookInformation> BookInformation();

    //模糊查询
    List<BookInformation> selectAllByLike(BookInformation bookInformation);

    //范围查询
    List<BookInformation> condition(BookInformation bookInformation);

    List<BookInformation> selectClimmsn();
}
