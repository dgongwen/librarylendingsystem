package com.dgw.book.entity;

import lombok.Data;

/**
 * 分页信息封装
 */

@Data
public class PageRequest {
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
     * 书本数量
     */
    private Integer bookCount;

    /**
     * 书本描述
     */
    private String bookDescribe;

    public PageRequest(Integer bookId, String bookName, String bookAuthor,  String bookDescribe) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookDescribe = bookDescribe;
    }




}
