package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "changehistory", schema = "edu_credit", catalog = "")
public class Changehistory {
    private static final String TAG = "Changehistory";
    private int id;
    private int entId;
    private String changeitem;
    private String beforecontent;
    private String aftercontent;
    private Date changedate;

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
    @Column(name = "changeitem")
    public String getChangeitem() {
        return changeitem;
    }

    public void setChangeitem(String changeitem) {
        this.changeitem = changeitem;
    }

    @Basic
    @Column(name = "beforecontent")
    public String getBeforecontent() {
        return beforecontent;
    }

    public void setBeforecontent(String beforecontent) {
        this.beforecontent = beforecontent;
    }

    @Basic
    @Column(name = "aftercontent")
    public String getAftercontent() {
        return aftercontent;
    }

    public void setAftercontent(String aftercontent) {
        this.aftercontent = aftercontent;
    }

    @Basic
    @Column(name = "changedate")
    public Date getChangedate() {
        return changedate;
    }

    public void setChangedate(Date changedate) {
        this.changedate = changedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Changehistory that = (Changehistory) o;
        return id == that.id &&
                entId == that.entId &&
                Objects.equals(changeitem, that.changeitem) &&
                Objects.equals(beforecontent, that.beforecontent) &&
                Objects.equals(aftercontent, that.aftercontent) &&
                Objects.equals(changedate, that.changedate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, changeitem, beforecontent, aftercontent, changedate);
    }
}
