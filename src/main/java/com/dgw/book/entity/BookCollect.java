package com.dgw.book.entity;
import lombok.Data;

/**
 * 收藏实体类
 */

@Data
public class BookCollect {

    private int bookCollectId;

    private int bookId;

    private String bookName;

    public BookCollect(int bookCollectId,int bookIds, String bookName) {
        this.bookCollectId=bookCollectId;
        this.bookId=bookIds;
        this.bookName=bookName;
    }

    public BookCollect(int bookId, String bookName) {
        this.bookId=bookId;
        this.bookName=bookName;
    }
}
