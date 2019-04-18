package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe: 企业法定代表人
 */
@Entity
@Table(name = "tb_ent_legal", schema = "edu_credit", catalog = "")
public class TbEntLegal {
    private static final String TAG = "TbEntLegal";
    private int id;
    private int entId;
    private String name;
    private String creditid;
    private Integer sex;
    private String address;
    private String mobphone;
    private Integer marry;
    private Date birthday;
    private Date startdate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ent_id")
    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
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
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "mobphone")
    public String getMobphone() {
        return mobphone;
    }

    public void setMobphone(String mobphone) {
        this.mobphone = mobphone;
    }

    @Basic
    @Column(name = "marry")
    public Integer getMarry() {
        return marry;
    }

    public void setMarry(Integer marry) {
        this.marry = marry;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
        TbEntLegal that = (TbEntLegal) o;
        return id == that.id &&
                entId == that.entId &&
                Objects.equals(name, that.name) &&
                Objects.equals(creditid, that.creditid) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mobphone, that.mobphone) &&
                Objects.equals(marry, that.marry) &&
                Objects.equals(birthday, that.birthday) &&
                Objects.equals(startdate, that.startdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, name, creditid, sex, address, mobphone, marry, birthday, startdate);
    }
}
