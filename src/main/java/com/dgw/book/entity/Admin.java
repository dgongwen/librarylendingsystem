package com.dgw.book.entity;
import java.io.Serializable;
import lombok.Data;

@Data
public class Admin implements Serializable {
    /**
     *
     */
    private String id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String sex;

    /**
     *
     */
    private String age;

    private static final long serialVersionUID = 1L;

    public Admin(String name, String password, String sex, String age) {
        this.name= name;
        this.password= password;
        this.sex= sex;
        this.age= age;

    }

    public Admin(String name) {
        this.name=name;
    }

    public Admin(String name, String password) {
        this.name=name;
        this.password=password;
    }

    public Admin(String id, String name1, String password, String sex, String age) {
        this.id=id;
        this.name=name1;
        this.sex=sex;
        this.password=password;
        this.age=age;
    }
}

