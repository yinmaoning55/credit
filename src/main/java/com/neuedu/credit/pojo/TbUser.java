package com.neuedu.credit.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:23.
 * @Describe:
 */
@Entity
@Table(name = "user")
public class TbUser implements Serializable{
    private static final String TAG = "User";
    private int id;
    private String name;
    private String alias;
    private String username;
    private transient String password;
    private String mobile;
    private String email;
    private String wxopenid;
    private Integer authentication;
    private Integer status;
    private Timestamp createtime;
    private Timestamp modifytime;
    private List<Role> roles;

    @ManyToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id"))
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "wxopenid")
    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid;
    }

    @Basic
    @Column(name = "authentication")
    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "createtime")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "modifytime")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Timestamp getModifytime() {
        return modifytime;
    }

    public void setModifytime(Timestamp modifytime) {
        this.modifytime = modifytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUser user = (TbUser) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(alias, user.alias) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(email, user.email) &&
                Objects.equals(wxopenid, user.wxopenid) &&
                Objects.equals(authentication, user.authentication) &&
                Objects.equals(status, user.status) &&
                Objects.equals(createtime, user.createtime) &&
                Objects.equals(modifytime, user.modifytime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, alias, username, password, mobile, email, wxopenid, authentication, status, createtime, modifytime);
    }
}
