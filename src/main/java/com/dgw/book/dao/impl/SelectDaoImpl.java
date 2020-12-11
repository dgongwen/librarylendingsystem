package com.dgw.book.dao.impl;
import com.dgw.book.dao.SelectDao;
import com.dgw.book.entity.Admin;
import com.dgw.book.entity.BookInformation;
import com.dgw.book.entity.PageRequest;
import com.dgw.book.utils.DbManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectDaoImpl implements SelectDao {

    //查询所有用户信息
    @Override
    public List<Admin> showAdmin() {
        String sql = "select id,name,password,sex,age from admin ";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            Statement statement1 = conn.createStatement();
            resultSet = statement1.executeQuery(sql);
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name1 = resultSet.getString("name");
                String password = resultSet.getString("password");
                String sex = resultSet.getString("sex");
                String age = resultSet.getString("age");
                Admin admin = new Admin(id,name1,password,sex,age);
                list.add(admin);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,statement,conn);
        }
        return list;
    }

    //查询所有书籍信息
    @Override
    public List<PageRequest> selectPageList() {

        String sql = "select book_id,book_name,book_author,book_describe from book_information ";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List<PageRequest> list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            Statement statement1 = conn.createStatement();
            resultSet = statement1.executeQuery(sql);
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String bookDescribe = resultSet.getString("book_describe");
                PageRequest pageRequest = new PageRequest(bookId,bookName,bookAuthor,bookDescribe);
                list.add(pageRequest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,statement,conn);
        }
        return list;
    }

    //查询总条数
    @Override
    public int selectCount() {

        int count = 0;
        String sql = "select book_id from book_information ;";
        Connection conn=null ;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        Statement statement = null;
        try {
            conn = DbManager.getInstance().getConn();
            statement = conn.createStatement();
           resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                Integer bookId=resultSet.getInt("book_id");
                count++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }finally {
            DbManager.getInstance().close(resultSet,ps,conn);
        }
        return count;
    }

    //查询所有书籍
    @Override
    public List<BookInformation> BookInformation() {

        String sql = "select * from book_information ";
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet=null;
        List<BookInformation> list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            Statement statement1 = conn.createStatement();
            resultSet = statement1.executeQuery(sql);
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String bookDescribe = resultSet.getString("book_describe");
                BookInformation pageRequest = new BookInformation(bookId,bookName,bookAuthor,bookDescribe);
                list.add(pageRequest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet,statement,conn);
        }
        return list;
    }

    //模糊查询
    @Override
    public List<BookInformation> selectAllByLike(BookInformation bookInformation) {
        String sql = "select * from book_information where book_describe like ? ";
        Connection conn = null;
        ResultSet resultSet=null;
        PreparedStatement prepared = null;
        List<BookInformation> list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
             prepared = conn.prepareStatement(sql);
             //模糊查询
            prepared.setString(1,"%"+bookInformation.getBookDescribe()+"%");
            resultSet = prepared.executeQuery();
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String bookDescribe = resultSet.getString("book_describe");
                BookInformation pageRequest = new BookInformation(bookId,bookName,bookAuthor,bookDescribe);
                list.add(pageRequest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet, prepared,conn);
        }
        return list;
    }

    //范围查询
    @Override
    public List<BookInformation> condition(BookInformation bookInformation) {
        String sql = "select * from book_information where book_price > ? and book_label = ? ";
        Connection conn = null;
        ResultSet resultSet=null;
        PreparedStatement prepared = null;
        List<BookInformation> list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            prepared = conn.prepareStatement(sql);
            //范围查询
            prepared.setInt(1,bookInformation.getBookPrice());
            prepared.setString(2,bookInformation.getBookLabel());
            resultSet = prepared.executeQuery();
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String bookDescribe = resultSet.getString("book_describe");
                int bookPrice = resultSet.getInt("book_price");
                BookInformation pageRequest = new BookInformation(bookId,bookName,bookAuthor,bookDescribe,bookPrice);
                list.add(pageRequest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet, prepared,conn);
        }
        return list;
    }

    //升序查询
    @Override
    public List<BookInformation> selectClimmsn() {
        String sql = "select * from book_information order by book_price asc";
        Connection conn = null;
        ResultSet resultSet=null;
        Statement statement = null;
        List<BookInformation> list = new ArrayList();
        try {
            conn = DbManager.getInstance().getConn();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int bookId = resultSet.getInt("book_id");
                String bookName = resultSet.getString("book_name");
                String bookAuthor = resultSet.getString("book_author");
                String bookDescribe = resultSet.getString("book_describe");
                int book_price = resultSet.getInt("book_price");
                BookInformation pageRequest = new BookInformation(bookId,bookName,bookAuthor,bookDescribe,book_price);
                list.add(pageRequest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            DbManager.getInstance().close(resultSet, statement,conn);
        }
        return list;
    }

}
