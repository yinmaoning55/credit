package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "beexecutor", schema = "edu_credit", catalog = "")
public class Beexecutor {
    private static final String TAG = "Beexecutor";
    private int id;
    private int entId;
    private String executortarget;
    private String casenum;
    private String court;
    private Date casedate;

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
    @Column(name = "executortarget")
    public String getExecutortarget() {
        return executortarget;
    }

    public void setExecutortarget(String executortarget) {
        this.executortarget = executortarget;
    }

    @Basic
    @Column(name = "casenum")
    public String getCasenum() {
        return casenum;
    }

    public void setCasenum(String casenum) {
        this.casenum = casenum;
    }

    @Basic
    @Column(name = "court")
    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    @Basic
    @Column(name = "casedate")
    public Date getCasedate() {
        return casedate;
    }

    public void setCasedate(Date casedate) {
        this.casedate = casedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beexecutor that = (Beexecutor) o;
        return id == that.id &&
                entId == that.entId &&
                Objects.equals(executortarget, that.executortarget) &&
                Objects.equals(casenum, that.casenum) &&
                Objects.equals(court, that.court) &&
                Objects.equals(casedate, that.casedate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, executortarget, casenum, court, casedate);
    }
}
