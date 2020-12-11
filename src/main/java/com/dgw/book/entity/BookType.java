package com.dgw.book.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class BookType implements Serializable {
    /**
     * 类型id
     */
    private Long bookTypeId;

    /**
     * 书本类型
     */
    private String bookTypeName;

    private static final long serialVersionUID = 1L;
}

