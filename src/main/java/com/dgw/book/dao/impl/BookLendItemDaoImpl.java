package com.dgw.book.dao.impl;
import com.dgw.book.dao.BookLendItemDao;
import com.dgw.book.entity.BookLend;
import com.dgw.book.entity.BookLendItem;
import com.dgw.book.entity.BookReturn;
import com.dgw.book.utils.DbManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookLendItemDaoImpl implements BookLendItemDao {


    //根据书本id修改对应书本库存数量
    @Override
    public int regularScript(BookLendItem bookLendItem) {
        String sql = "update book_count set book_count_num = book_count_num-1 where book_id = ?";
        Connection conn = null;
        PreparedStatement prepared = null;
        int i = 0;
        try {
            conn = DbManager.getInstance().getConn();
            prepared = conn.prepareStatement(sql);
            prepared.setInt(1,bookLendItem.getBookId());
            i = prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close(prepared,conn);
        }
        return i;

    }

    //添加借书数据
    @Override
    public int insertLendBook(BookLend bookLend) {
        String sql = "insert into book_lend(book_lend_name,lend_time,return_time) value (?,?,?)";
        Connection conn = null;
        PreparedStatement prepared = null;
        int i = 0;
        try {
            conn = DbManager.getInstance().getConn();
            prepared = conn.prepareStatement(sql);
          prepared.setString(1,bookLend.getBookLendName());
          prepared.setString(2,bookLend.getLendTime());
          prepared.setString(3,bookLend.getReturnTime());
            i = prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close(prepared,conn);
        }
        return i;
    }

    //查询借书更新数据
    @Override
    public List<BookLend> selectBookLend() {
        String sql = "select book_lend_name,lend_time,return_time from book_lend ";
        Connection conn = null;
        ResultSet resultSet=null;
        Statement statement = null;
        List list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String name = resultSet.getString("book_lend_name");
                String lendTime = resultSet.getString("lend_time");
                String returnTime = resultSet.getString("return_time");
                BookLend bookLend = new BookLend(name,lendTime,returnTime);
                list.add(bookLend);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,statement,conn);
        }
        return list;

    }

    //归还,修改库存数量
    @Override
    public int updateReturnBook(BookReturn bookReturn) {
        String sql = "update book_count set book_count_num = book_count_num+1 where book_id = ?";
        Connection conn = null;
        PreparedStatement prepared = null;
        int i = 0;
        try {
            conn = DbManager.getInstance().getConn();
            prepared = conn.prepareStatement(sql);
            prepared.setInt(1,bookReturn.getBookId());
            i = prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close(prepared,conn);
        }
        return i;

    }

    //查询归还更新数据
    @Override
    public List<BookReturn> selectReturn() {
        String sql = "select  book_id,return_time,return_book_name from book_return ";
        Connection conn = null;
        ResultSet resultSet=null;
        Statement statement = null;
        List list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String returnTime = resultSet.getString("return_time");
                String returnBookName = resultSet.getString("return_book_name");
                BookReturn bookReturn = new BookReturn(bookId,returnTime,returnBookName);
                list.add(bookReturn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,statement,conn);
        }
        return list;
    }

    //保存还书数据
    @Override
    public int insertBookReturn(BookReturn aReturn) {
        String sql = "insert into book_return( book_id,return_time,return_book_name) value (?,?,?)";
        Connection conn = null;
        PreparedStatement prepared = null;
        int i = 0;
        try {
            conn = DbManager.getInstance().getConn();
            prepared = conn.prepareStatement(sql);
            prepared.setInt(1,aReturn.getBookId());
            prepared.setString(2,aReturn.getReturnTime());
            prepared.setString(3,aReturn.getReturnBookName());
            i = prepared.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.getInstance().close(prepared,conn);
        }
        return i;
    }
}
