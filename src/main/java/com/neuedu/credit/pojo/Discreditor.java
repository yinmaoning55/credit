package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "discreditor", schema = "edu_credit", catalog = "")
public class Discreditor {
    private static final String TAG = "Discreditor";
    private int id;
    private int entId;
    private String executbasenum;
    private String casenum;
    private String court;
    private Date casedate;
    private String executorstatus;

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
    @Column(name = "executbasenum")
    public String getExecutbasenum() {
        return executbasenum;
    }

    public void setExecutbasenum(String executbasenum) {
        this.executbasenum = executbasenum;
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

    @Basic
    @Column(name = "executorstatus")
    public String getExecutorstatus() {
        return executorstatus;
    }

    public void setExecutorstatus(String executorstatus) {
        this.executorstatus = executorstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discreditor that = (Discreditor) o;
        return id == that.id &&
                entId == that.entId &&
                Objects.equals(executbasenum, that.executbasenum) &&
                Objects.equals(casenum, that.casenum) &&
                Objects.equals(court, that.court) &&
                Objects.equals(casedate, that.casedate) &&
                Objects.equals(executorstatus, that.executorstatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, executbasenum, casenum, court, casedate, executorstatus);
    }
}
