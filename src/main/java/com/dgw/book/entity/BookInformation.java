package com.dgw.book.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class BookInformation implements Serializable {
    /**
     * 书本id
     */
    private Integer bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 书作者
     */
    private String bookAuthor;


    /**
     * 书本描述
     */
    private String bookDescribe;

    /**
     * 书本单价
     */
    private int  bookPrice;

    /**
     * 书本标签
     */

    private  String  bookLabel;

    private static final long serialVersionUID = 1L;


    public BookInformation(Integer bookId, String bookName, String bookAuthor, String bookDescribe,int  bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescribe = bookDescribe;
        this.bookPrice = bookPrice;
    }

    public BookInformation(String bookDescribe) {
        this.bookDescribe=bookDescribe;
    }

    public BookInformation(String bookLabel, int bookPrice) {
        this.bookLabel = bookLabel;
        this.bookPrice = bookPrice;
    }

    public BookInformation(Integer bookId, String bookName, String bookAuthor, String bookDescribe) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescribe = bookDescribe;
    }
}

