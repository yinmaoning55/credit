package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "tb_enterprise", schema = "edu_credit", catalog = "")
public class TbEnterprise {
    private int entid;
    private String creditnum;
    private String entname;
    private String registernum;
    private String orgnizationnum;
    private String entstatus;
    private String entrtype;
    private String registermoney;
    private String registeraddr;
    private String registergovment;
    private Date registertime;
    private Date llicensetodate;
    private Date approvedate;
    private String buessionscope;
    private String mainincome;
    private Integer employeesnum;
    private String industry;
    private String englishname;
    private byte[] entnature;
    private String province;
    private String city;
    private String contactname;
    private String cantactphone;
    private String contacttitle;
    private Timestamp createtime;

    @Id
    @Column(name = "entid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEntid() {
        return entid;
    }

    public void setEntid(int entid) {
        this.entid = entid;
    }

    @Basic
    @Column(name = "creditnum")
    public String getCreditnum() {
        return creditnum;
    }

    public void setCreditnum(String creditnum) {
        this.creditnum = creditnum;
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
    @Column(name = "registernum")
    public String getRegisternum() {
        return registernum;
    }

    public void setRegisternum(String registernum) {
        this.registernum = registernum;
    }

    @Basic
    @Column(name = "orgnizationnum")
    public String getOrgnizationnum() {
        return orgnizationnum;
    }

    public void setOrgnizationnum(String orgnizationnum) {
        this.orgnizationnum = orgnizationnum;
    }

    @Basic
    @Column(name = "entstatus")
    public String getEntstatus() {
        return entstatus;
    }

    public void setEntstatus(String entstatus) {
        this.entstatus = entstatus;
    }

    @Basic
    @Column(name = "entrtype")
    public String getEntrtype() {
        return entrtype;
    }

    public void setEntrtype(String entrtype) {
        this.entrtype = entrtype;
    }

    @Basic
    @Column(name = "registermoney")
    public String getRegistermoney() {
        return registermoney;
    }

    public void setRegistermoney(String registermoney) {
        this.registermoney = registermoney;
    }

    @Basic
    @Column(name = "registeraddr")
    public String getRegisteraddr() {
        return registeraddr;
    }

    public void setRegisteraddr(String registeraddr) {
        this.registeraddr = registeraddr;
    }

    @Basic
    @Column(name = "registergovment")
    public String getRegistergovment() {
        return registergovment;
    }

    public void setRegistergovment(String registergovment) {
        this.registergovment = registergovment;
    }

    @Basic
    @Column(name = "registertime")
    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    @Basic
    @Column(name = "llicensetodate")
    public Date getLlicensetodate() {
        return llicensetodate;
    }

    public void setLlicensetodate(Date llicensetodate) {
        this.llicensetodate = llicensetodate;
    }

    @Basic
    @Column(name = "approvedate")
    public Date getApprovedate() {
        return approvedate;
    }

    public void setApprovedate(Date approvedate) {
        this.approvedate = approvedate;
    }

    @Basic
    @Column(name = "buessionscope")
    public String getBuessionscope() {
        return buessionscope;
    }

    public void setBuessionscope(String buessionscope) {
        this.buessionscope = buessionscope;
    }

    @Basic
    @Column(name = "mainincome")
    public String getMainincome() {
        return mainincome;
    }

    public void setMainincome(String mainincome) {
        this.mainincome = mainincome;
    }

    @Basic
    @Column(name = "employeesnum")
    public Integer getEmployeesnum() {
        return employeesnum;
    }

    public void setEmployeesnum(Integer employeesnum) {
        this.employeesnum = employeesnum;
    }

    @Basic
    @Column(name = "industry")
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Basic
    @Column(name = "englishname")
    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }

    @Basic
    @Column(name = "entnature")
    public byte[] getEntnature() {
        return entnature;
    }

    public void setEntnature(byte[] entnature) {
        this.entnature = entnature;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "contactname")
    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    @Basic
    @Column(name = "cantactphone")
    public String getCantactphone() {
        return cantactphone;
    }

    public void setCantactphone(String cantactphone) {
        this.cantactphone = cantactphone;
    }

    @Basic
    @Column(name = "contacttitle")
    public String getContacttitle() {
        return contacttitle;
    }

    public void setContacttitle(String contacttitle) {
        this.contacttitle = contacttitle;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbEnterprise that = (TbEnterprise) o;
        return entid == that.entid &&
                Objects.equals(creditnum, that.creditnum) &&
                Objects.equals(entname, that.entname) &&
                Objects.equals(registernum, that.registernum) &&
                Objects.equals(orgnizationnum, that.orgnizationnum) &&
                Objects.equals(entstatus, that.entstatus) &&
                Objects.equals(entrtype, that.entrtype) &&
                Objects.equals(registermoney, that.registermoney) &&
                Objects.equals(registeraddr, that.registeraddr) &&
                Objects.equals(registergovment, that.registergovment) &&
                Objects.equals(registertime, that.registertime) &&
                Objects.equals(llicensetodate, that.llicensetodate) &&
                Objects.equals(approvedate, that.approvedate) &&
                Objects.equals(buessionscope, that.buessionscope) &&
                Objects.equals(mainincome, that.mainincome) &&
                Objects.equals(employeesnum, that.employeesnum) &&
                Objects.equals(industry, that.industry) &&
                Objects.equals(englishname, that.englishname) &&
                Arrays.equals(entnature, that.entnature) &&
                Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(contactname, that.contactname) &&
                Objects.equals(cantactphone, that.cantactphone) &&
                Objects.equals(contacttitle, that.contacttitle) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(entid, creditnum, entname, registernum, orgnizationnum, entstatus, entrtype, registermoney, registeraddr, registergovment, registertime, llicensetodate, approvedate, buessionscope, mainincome, employeesnum, industry, englishname, province, city, contactname, cantactphone, contacttitle, createtime);
        result = 31 * result + Arrays.hashCode(entnature);
        return result;
    }
}
