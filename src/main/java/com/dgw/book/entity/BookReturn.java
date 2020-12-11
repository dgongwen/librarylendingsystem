package com.dgw.book.entity;
import lombok.Data;

@Data
public class BookReturn {

    //归还id
    private int   returnId;

    //书本id
    private  int bookId;

    //归还时间
    private String returnTime;

    //归还书名
    private String  returnBookName;


    public BookReturn(int bookId, String returnBookName) {
        this.bookId = bookId;
        this.returnBookName = returnBookName;
    }

    public BookReturn() {

    }

    public BookReturn(int bookId, String returnTime, String returnBookName) {
        this.bookId = bookId;
        this.returnTime = returnTime;
        this.returnBookName = returnBookName;
    }
}
