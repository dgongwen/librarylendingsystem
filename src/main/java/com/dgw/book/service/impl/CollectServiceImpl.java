package com.dgw.book.service.impl;
import com.dgw.book.dao.CollectDao;
import com.dgw.book.dao.impl.CollectDaoImpl;
import com.dgw.book.entity.BookCollect;
import com.dgw.book.service.CollectService;

public class CollectServiceImpl implements CollectService {
    CollectDao collectDao = new CollectDaoImpl();

    /**
     * 1,查询收藏夹是否已经存在相对于书籍
     * 2,不存在添加,存在提示(已经存在收藏)
     *
     * @param bookCollect
     * @return
     */

    @Override
    public int addCollect(BookCollect bookCollect) {
        int i = 0;
        //1,查询收藏记录
        BookCollect Collect = collectDao.selectCollect(bookCollect);
               if(Collect!=null){
                    //判断是否存在相同收藏记录,没有直接添加收藏,有的话添加失败
                    if(Collect.getBookId()==bookCollect.getBookId()&&Collect.getBookName().equals(bookCollect.getBookName())){
                        System.out.println("已存在,收藏失败");
                        return 0;
                    }

               }else{
                   //不存在添加收藏
                    i = collectDao.addEnshrine(bookCollect);
               }

                    return i;
    }
}
