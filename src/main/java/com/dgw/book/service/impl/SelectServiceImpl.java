package com.dgw.book.service.impl;
import com.dgw.book.dao.SelectDao;
import com.dgw.book.dao.impl.SelectDaoImpl;
import com.dgw.book.entity.BookInformation;
import com.dgw.book.entity.PageBean;
import com.dgw.book.entity.PageRequest;
import com.dgw.book.service.SelectService;
import java.util.List;

public class SelectServiceImpl implements SelectService {
    SelectDao selectDao = new SelectDaoImpl();

    //分页展示
    @Override
    public PageBean<PageRequest> pageBook() {
        //查的所有书籍信息
        List<PageRequest> pageRequests = selectDao.selectPageList();
        //查的总条数
        int i = selectDao.selectCount();
        PageBean<PageRequest> PageBean = new PageBean<>();
        //得到全部数据,并设置进去
        PageBean.setSelectUserDataA(pageRequests);
        //得到总条数,并设置展示的条数规定
        PageBean.setPageSize(i);
        //得到总条数,并设置进去,计算总页数
        PageBean.setTotalPage(i);
        //设置总条数
        PageBean.setTotalCount(i);
        return  PageBean;
    }

    //展示所有商品信息
    @Override
    public List<BookInformation> selectBook() {
        return selectDao.BookInformation();
    }

    //模糊查询
    @Override
    public List<BookInformation> selectLike(BookInformation bookInformation) {
        return selectDao.selectAllByLike(bookInformation);
    }

    //范围查询
    @Override
    public List<BookInformation> selectCondition(BookInformation bookInformation) {
        return selectDao.condition(bookInformation);
    }

    //升序查询
    @Override
    public List<BookInformation> selectAscending() {
        return selectDao.selectClimmsn();
    }
}
