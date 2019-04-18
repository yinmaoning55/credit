package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:23.
 * @Describe:
 */
@Entity
@Table(name = "uc_reptprofitassign", schema = "edu_credit", catalog = "")
public class UcReptprofitassign {
    private static final String TAG = "UcReptprofitassign";
    private BigDecimal item1;
    private BigDecimal item2;
    private BigDecimal item3;
    private BigDecimal item4;
    private BigDecimal item5;
    private BigDecimal item6;
    private BigDecimal item7;
    private BigDecimal item8;
    private BigDecimal item9;
    private BigDecimal item10;
    private BigDecimal item11;
    private BigDecimal item12;
    private BigDecimal item13;
    private BigDecimal item14;
    private BigDecimal item15;
    private BigDecimal item16;
    private BigDecimal item17;
    private BigDecimal item18;
    private BigDecimal item19;
    private String oproccurdate;
    private String reportyear;
    private String borrowernamecn;
    private int id;

    @Basic
    @Column(name = "ITEM1")
    public BigDecimal getItem1() {
        return item1;
    }

    public void setItem1(BigDecimal item1) {
        this.item1 = item1;
    }

    @Basic
    @Column(name = "ITEM2")
    public BigDecimal getItem2() {
        return item2;
    }

    public void setItem2(BigDecimal item2) {
        this.item2 = item2;
    }

    @Basic
    @Column(name = "ITEM3")
    public BigDecimal getItem3() {
        return item3;
    }

    public void setItem3(BigDecimal item3) {
        this.item3 = item3;
    }

    @Basic
    @Column(name = "ITEM4")
    public BigDecimal getItem4() {
        return item4;
    }

    public void setItem4(BigDecimal item4) {
        this.item4 = item4;
    }

    @Basic
    @Column(name = "ITEM5")
    public BigDecimal getItem5() {
        return item5;
    }

    public void setItem5(BigDecimal item5) {
        this.item5 = item5;
    }

    @Basic
    @Column(name = "ITEM6")
    public BigDecimal getItem6() {
        return item6;
    }

    public void setItem6(BigDecimal item6) {
        this.item6 = item6;
    }

    @Basic
    @Column(name = "ITEM7")
    public BigDecimal getItem7() {
        return item7;
    }

    public void setItem7(BigDecimal item7) {
        this.item7 = item7;
    }

    @Basic
    @Column(name = "ITEM8")
    public BigDecimal getItem8() {
        return item8;
    }

    public void setItem8(BigDecimal item8) {
        this.item8 = item8;
    }

    @Basic
    @Column(name = "ITEM9")
    public BigDecimal getItem9() {
        return item9;
    }

    public void setItem9(BigDecimal item9) {
        this.item9 = item9;
    }

    @Basic
    @Column(name = "ITEM10")
    public BigDecimal getItem10() {
        return item10;
    }

    public void setItem10(BigDecimal item10) {
        this.item10 = item10;
    }

    @Basic
    @Column(name = "ITEM11")
    public BigDecimal getItem11() {
        return item11;
    }

    public void setItem11(BigDecimal item11) {
        this.item11 = item11;
    }

    @Basic
    @Column(name = "ITEM12")
    public BigDecimal getItem12() {
        return item12;
    }

    public void setItem12(BigDecimal item12) {
        this.item12 = item12;
    }

    @Basic
    @Column(name = "ITEM13")
    public BigDecimal getItem13() {
        return item13;
    }

    public void setItem13(BigDecimal item13) {
        this.item13 = item13;
    }

    @Basic
    @Column(name = "ITEM14")
    public BigDecimal getItem14() {
        return item14;
    }

    public void setItem14(BigDecimal item14) {
        this.item14 = item14;
    }

    @Basic
    @Column(name = "ITEM15")
    public BigDecimal getItem15() {
        return item15;
    }

    public void setItem15(BigDecimal item15) {
        this.item15 = item15;
    }

    @Basic
    @Column(name = "ITEM16")
    public BigDecimal getItem16() {
        return item16;
    }

    public void setItem16(BigDecimal item16) {
        this.item16 = item16;
    }

    @Basic
    @Column(name = "ITEM17")
    public BigDecimal getItem17() {
        return item17;
    }

    public void setItem17(BigDecimal item17) {
        this.item17 = item17;
    }

    @Basic
    @Column(name = "ITEM18")
    public BigDecimal getItem18() {
        return item18;
    }

    public void setItem18(BigDecimal item18) {
        this.item18 = item18;
    }

    @Basic
    @Column(name = "ITEM19")
    public BigDecimal getItem19() {
        return item19;
    }

    public void setItem19(BigDecimal item19) {
        this.item19 = item19;
    }

    @Basic
    @Column(name = "OPROCCURDATE")
    public String getOproccurdate() {
        return oproccurdate;
    }

    public void setOproccurdate(String oproccurdate) {
        this.oproccurdate = oproccurdate;
    }

    @Basic
    @Column(name = "REPORTYEAR")
    public String getReportyear() {
        return reportyear;
    }

    public void setReportyear(String reportyear) {
        this.reportyear = reportyear;
    }

    @Basic
    @Column(name = "BORROWERNAMECN")
    public String getBorrowernamecn() {
        return borrowernamecn;
    }

    public void setBorrowernamecn(String borrowernamecn) {
        this.borrowernamecn = borrowernamecn;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UcReptprofitassign that = (UcReptprofitassign) o;
        return id == that.id &&
                Objects.equals(item1, that.item1) &&
                Objects.equals(item2, that.item2) &&
                Objects.equals(item3, that.item3) &&
                Objects.equals(item4, that.item4) &&
                Objects.equals(item5, that.item5) &&
                Objects.equals(item6, that.item6) &&
                Objects.equals(item7, that.item7) &&
                Objects.equals(item8, that.item8) &&
                Objects.equals(item9, that.item9) &&
                Objects.equals(item10, that.item10) &&
                Objects.equals(item11, that.item11) &&
                Objects.equals(item12, that.item12) &&
                Objects.equals(item13, that.item13) &&
                Objects.equals(item14, that.item14) &&
                Objects.equals(item15, that.item15) &&
                Objects.equals(item16, that.item16) &&
                Objects.equals(item17, that.item17) &&
                Objects.equals(item18, that.item18) &&
                Objects.equals(item19, that.item19) &&
                Objects.equals(oproccurdate, that.oproccurdate) &&
                Objects.equals(reportyear, that.reportyear) &&
                Objects.equals(borrowernamecn, that.borrowernamecn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, item16, item17, item18, item19, oproccurdate, reportyear, borrowernamecn, id);
    }
}
