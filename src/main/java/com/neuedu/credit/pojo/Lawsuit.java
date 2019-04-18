package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "lawsuit", schema = "edu_credit", catalog = "")
public class Lawsuit {
    private static final String TAG = "Lawsuit";
    private int id;
    private String judgetitle;
    private String casenum;
    private String casepoint;
    private String prosecutor;
    private String defendant;
    private Date judgedate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "judgetitle")
    public String getJudgetitle() {
        return judgetitle;
    }

    public void setJudgetitle(String judgetitle) {
        this.judgetitle = judgetitle;
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
    @Column(name = "casepoint")
    public String getCasepoint() {
        return casepoint;
    }

    public void setCasepoint(String casepoint) {
        this.casepoint = casepoint;
    }

    @Basic
    @Column(name = "prosecutor")
    public String getProsecutor() {
        return prosecutor;
    }

    public void setProsecutor(String prosecutor) {
        this.prosecutor = prosecutor;
    }

    @Basic
    @Column(name = "defendant")
    public String getDefendant() {
        return defendant;
    }

    public void setDefendant(String defendant) {
        this.defendant = defendant;
    }

    @Basic
    @Column(name = "judgedate")
    public Date getJudgedate() {
        return judgedate;
    }

    public void setJudgedate(Date judgedate) {
        this.judgedate = judgedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lawsuit lawsuit = (Lawsuit) o;
        return id == lawsuit.id &&
                Objects.equals(judgetitle, lawsuit.judgetitle) &&
                Objects.equals(casenum, lawsuit.casenum) &&
                Objects.equals(casepoint, lawsuit.casepoint) &&
                Objects.equals(prosecutor, lawsuit.prosecutor) &&
                Objects.equals(defendant, lawsuit.defendant) &&
                Objects.equals(judgedate, lawsuit.judgedate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, judgetitle, casenum, casepoint, prosecutor, defendant, judgedate);
    }
}
