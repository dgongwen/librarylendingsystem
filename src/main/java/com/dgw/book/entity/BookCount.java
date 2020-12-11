package com.dgw.book.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class BookCount implements Serializable {
    /**
     * 库存id
     */
    private Long bookCountId;

    /**
     * 书本id
     */
    private Long bookId;

    /**
     * 库存数量
     */
    private Long bookCountNum;

    /**
     * 库存状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}

