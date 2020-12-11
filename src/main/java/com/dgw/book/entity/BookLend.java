package com.dgw.book.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class BookLend implements Serializable {
    /**
     * 借出id
     */
    private Long bookLendId;

    /**
     * 借出书名
     */
    private String bookLendName;

    /**
     * 借出时间
     */
    private String lendTime;

    /**
     * 还书时间
     */
    private String returnTime;

    private static final long serialVersionUID = 1L;

    public BookLend(String bookLendName, String lendTime, String returnTime) {
        this.bookLendName = bookLendName;
        this.lendTime = lendTime;
        this.returnTime = returnTime;
    }

    public BookLend() {

    }
}

