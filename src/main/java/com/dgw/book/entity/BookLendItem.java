package com.dgw.book.entity;
import lombok.Data;

@Data
public class BookLendItem {

    /**
     * 书本id
     */
    private int bookId;

    /**
     * 书名
     */
    private String bookName;

    public BookLendItem(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public BookLendItem() {

    }
}
