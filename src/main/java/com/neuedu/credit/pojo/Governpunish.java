package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "governpunish", schema = "edu_credit", catalog = "")
public class Governpunish {
    private static final String TAG = "Governpunish";
    private int id;
    private int entId;
    private String decidedocnum;
    private String decidegovernment;
    private Date decidedate;
    private String decidetype;
    private String content;
    private String remark;

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
    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    @Basic
    @Column(name = "decidedocnum")
    public String getDecidedocnum() {
        return decidedocnum;
    }

    public void setDecidedocnum(String decidedocnum) {
        this.decidedocnum = decidedocnum;
    }

    @Basic
    @Column(name = "decidegovernment")
    public String getDecidegovernment() {
        return decidegovernment;
    }

    public void setDecidegovernment(String decidegovernment) {
        this.decidegovernment = decidegovernment;
    }

    @Basic
    @Column(name = "decidedate")
    public Date getDecidedate() {
        return decidedate;
    }

    public void setDecidedate(Date decidedate) {
        this.decidedate = decidedate;
    }

    @Basic
    @Column(name = "decidetype")
    public String getDecidetype() {
        return decidetype;
    }

    public void setDecidetype(String decidetype) {
        this.decidetype = decidetype;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Governpunish that = (Governpunish) o;
        return id == that.id &&
                entId == that.entId &&
                Objects.equals(decidedocnum, that.decidedocnum) &&
                Objects.equals(decidegovernment, that.decidegovernment) &&
                Objects.equals(decidedate, that.decidedate) &&
                Objects.equals(decidetype, that.decidetype) &&
                Objects.equals(content, that.content) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, decidedocnum, decidegovernment, decidedate, decidetype, content, remark);
    }
}
