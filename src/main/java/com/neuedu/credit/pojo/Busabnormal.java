package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "busabnormal", schema = "edu_credit", catalog = "")
public class Busabnormal {
    private static final String TAG = "Busabnormal";
    private int id;
    private int entId;
    private String inreason;
    private String ingovernment;
    private Date indate;
    private String outreason;
    private String outgovernment;
    private Date outdate;

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
    @Column(name = "inreason")
    public String getInreason() {
        return inreason;
    }

    public void setInreason(String inreason) {
        this.inreason = inreason;
    }

    @Basic
    @Column(name = "ingovernment")
    public String getIngovernment() {
        return ingovernment;
    }

    public void setIngovernment(String ingovernment) {
        this.ingovernment = ingovernment;
    }

    @Basic
    @Column(name = "indate")
    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    @Basic
    @Column(name = "outreason")
    public String getOutreason() {
        return outreason;
    }

    public void setOutreason(String outreason) {
        this.outreason = outreason;
    }

    @Basic
    @Column(name = "outgovernment")
    public String getOutgovernment() {
        return outgovernment;
    }

    public void setOutgovernment(String outgovernment) {
        this.outgovernment = outgovernment;
    }

    @Basic
    @Column(name = "outdate")
    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Busabnormal that = (Busabnormal) o;
        return id == that.id &&
                entId == that.entId &&
                Objects.equals(inreason, that.inreason) &&
                Objects.equals(ingovernment, that.ingovernment) &&
                Objects.equals(indate, that.indate) &&
                Objects.equals(outreason, that.outreason) &&
                Objects.equals(outgovernment, that.outgovernment) &&
                Objects.equals(outdate, that.outdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, inreason, ingovernment, indate, outreason, outgovernment, outdate);
    }
}
