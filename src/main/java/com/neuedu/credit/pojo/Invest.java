package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "invest", schema = "edu_credit", catalog = "")
public class Invest {
    private static final String TAG = "Invest";
    private int id;
    private int mainEntId;
    private String entname;
    private String entcreditid;
    private String legalname;
    private Double registermoney;
    private Double fundingratio;
    private Date fundingdate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "main_ent_id")
    public int getMainEntId() {
        return mainEntId;
    }

    public void setMainEntId(int mainEntId) {
        this.mainEntId = mainEntId;
    }

    @Basic
    @Column(name = "entname")
    public String getEntname() {
        return entname;
    }

    public void setEntname(String entname) {
        this.entname = entname;
    }

    @Basic
    @Column(name = "entcreditid")
    public String getEntcreditid() {
        return entcreditid;
    }

    public void setEntcreditid(String entcreditid) {
        this.entcreditid = entcreditid;
    }

    @Basic
    @Column(name = "legalname")
    public String getLegalname() {
        return legalname;
    }

    public void setLegalname(String legalname) {
        this.legalname = legalname;
    }

    @Basic
    @Column(name = "registermoney")
    public Double getRegistermoney() {
        return registermoney;
    }

    public void setRegistermoney(Double registermoney) {
        this.registermoney = registermoney;
    }

    @Basic
    @Column(name = "fundingratio")
    public Double getFundingratio() {
        return fundingratio;
    }

    public void setFundingratio(Double fundingratio) {
        this.fundingratio = fundingratio;
    }

    @Basic
    @Column(name = "fundingdate")
    public Date getFundingdate() {
        return fundingdate;
    }

    public void setFundingdate(Date fundingdate) {
        this.fundingdate = fundingdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invest invest = (Invest) o;
        return id == invest.id &&
                mainEntId == invest.mainEntId &&
                Objects.equals(entname, invest.entname) &&
                Objects.equals(entcreditid, invest.entcreditid) &&
                Objects.equals(legalname, invest.legalname) &&
                Objects.equals(registermoney, invest.registermoney) &&
                Objects.equals(fundingratio, invest.fundingratio) &&
                Objects.equals(fundingdate, invest.fundingdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, mainEntId, entname, entcreditid, legalname, registermoney, fundingratio, fundingdate);
    }
}
