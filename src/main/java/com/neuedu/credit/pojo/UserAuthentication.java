package com.neuedu.credit.pojo;

import javax.persistence.*;

/**
 * @Created by elvin on 2018/9/25 14:49.
 * @Describe:
 */
@Entity
@Table(name = "user_authentication")
public class UserAuthentication {

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id",nullable = false)
    private Integer userid ;
    @Column(name = "authenticationtype",nullable = false)
    private Integer authenticationtype;
    @Column(name = "authenticationinfo_id",nullable = false)
    private int authenticationinfoid;
    @Column(name = "status",nullable = false)
    private Integer status;
    @Column(name = "remark")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return userid;
    }

    public void setUser_id(Integer user_id) {
        this.userid = user_id;
    }

    public Integer getAuthenticationtype() {
        return authenticationtype;
    }

    public void setAuthenticationtype(Integer authenticationtype) {
        this.authenticationtype = authenticationtype;
    }

    public int getAuthenticationinfo_id() {
        return authenticationinfoid;
    }

    public void setAuthenticationinfo_id(int authenticationinfo_id) {
        this.authenticationinfoid = authenticationinfo_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
