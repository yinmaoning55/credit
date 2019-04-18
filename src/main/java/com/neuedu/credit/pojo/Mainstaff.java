package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "mainstaff", schema = "edu_credit", catalog = "")
public class Mainstaff {
    private static final String TAG = "Mainstaff";
    private int id;
    private Integer entId;
    private String name;
    private String creditid;
    private String roles;
    private Date startdate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ent_id")
    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
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
    @Column(name = "creditid")
    public String getCreditid() {
        return creditid;
    }

    public void setCreditid(String creditid) {
        this.creditid = creditid;
    }

    @Basic
    @Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "startdate")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mainstaff mainstaff = (Mainstaff) o;
        return id == mainstaff.id &&
                Objects.equals(entId, mainstaff.entId) &&
                Objects.equals(name, mainstaff.name) &&
                Objects.equals(creditid, mainstaff.creditid) &&
                Objects.equals(roles, mainstaff.roles) &&
                Objects.equals(startdate, mainstaff.startdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, name, creditid, roles, startdate);
    }
}
