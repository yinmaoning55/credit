package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "partner", schema = "edu_credit", catalog = "")
public class Partner {
    private static final String TAG = "Partner";
    private int id;
    private int entId;
    private String partnername;
    private String partnercreditid;
    private Boolean partnertype;
    private Double fundingratio;
    private Double funding;
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
    @Column(name = "ent_id")
    public int getEntId() {
        return entId;
    }

    public void setEntId(int entId) {
        this.entId = entId;
    }

    @Basic
    @Column(name = "partnername")
    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }

    @Basic
    @Column(name = "partnercreditid")
    public String getPartnercreditid() {
        return partnercreditid;
    }

    public void setPartnercreditid(String partnercreditid) {
        this.partnercreditid = partnercreditid;
    }

    @Basic
    @Column(name = "partnertype")
    public Boolean getPartnertype() {
        return partnertype;
    }

    public void setPartnertype(Boolean partnertype) {
        this.partnertype = partnertype;
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
    @Column(name = "funding")
    public Double getFunding() {
        return funding;
    }

    public void setFunding(Double funding) {
        this.funding = funding;
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
        Partner partner = (Partner) o;
        return id == partner.id &&
                entId == partner.entId &&
                Objects.equals(partnername, partner.partnername) &&
                Objects.equals(partnercreditid, partner.partnercreditid) &&
                Objects.equals(partnertype, partner.partnertype) &&
                Objects.equals(fundingratio, partner.fundingratio) &&
                Objects.equals(funding, partner.funding) &&
                Objects.equals(fundingdate, partner.fundingdate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, entId, partnername, partnercreditid, partnertype, fundingratio, funding, fundingdate);
    }
}
