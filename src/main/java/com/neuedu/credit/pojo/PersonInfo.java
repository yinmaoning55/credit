package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Created by elvin on 2018/9/25 14:44.
 * @Describe:
 */
@Entity
@Table(name = "user_person")
public class PersonInfo {

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false,length = 11)
    private String name;
    @Column(name = "idcard",nullable = false,length = 18)
    private String idcard;
    @Column(name = "mobile",nullable = false,length = 18)
    private String mobile;
    @Column(name = "createtime",nullable = false)
    private Timestamp createtime;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }


}
