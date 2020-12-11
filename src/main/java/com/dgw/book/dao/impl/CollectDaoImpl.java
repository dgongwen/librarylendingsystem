package com.dgw.book.dao.impl;
import com.dgw.book.dao.CollectDao;
import com.dgw.book.entity.BookCollect;
import com.dgw.book.utils.DbManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollectDaoImpl implements CollectDao {

    //添加收藏
    @Override
    public int addEnshrine(BookCollect bookCollect) {

        String sql = "insert into book_collect(book_id,book_name) value (?,?)";
        Connection conn = null;
        PreparedStatement prepared = null;
        int i = 0;
        try {
            conn = DbManager.getInstance().getConn();
            prepared = conn.prepareStatement(sql);
            prepared.setInt(1,bookCollect.getBookId());
            prepared.setString(2,bookCollect.getBookName());
            i = prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close(prepared,conn);
        }
        return i;

    }

    //查询收藏记录
    @Override
    public BookCollect selectCollect(BookCollect bookCollect) {
        BookCollect collect = null;
        String sql = "select book_id,book_name from book_collect where book_id=?";
        Connection conn = null;
        PreparedStatement prepared = null;
        ResultSet resultSet=null;
        try {
            conn = DbManager.getInstance().getConn();
             prepared = conn.prepareStatement(sql);
            prepared.setInt(1,bookCollect.getBookId());
             resultSet = prepared.executeQuery();
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                collect = new BookCollect(bookId,bookName);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,prepared,conn);
        }

        return collect;
    }
}
