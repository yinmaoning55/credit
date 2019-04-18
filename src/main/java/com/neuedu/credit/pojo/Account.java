package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "account")
public class Account {
    private static final String TAG = "Account";
    private int id;
    private Integer userId;
    private Long useableFund;
    private Integer forzenFund;
    private Long totalConsumption;
    private String paymentpassword;
    private Timestamp modifytime;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "useable_fund")
    public Long getUseableFund() {
        return useableFund;
    }

    public void setUseableFund(Long useableFund) {
        this.useableFund = useableFund;
    }

    @Basic
    @Column(name = "forzen_fund")
    public Integer getForzenFund() {
        return forzenFund;
    }

    public void setForzenFund(Integer forzenFund) {
        this.forzenFund = forzenFund;
    }

    @Basic
    @Column(name = "total_consumption")
    public Long getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(Long totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    @Basic
    @Column(name = "paymentpassword")
    public String getPaymentpassword() {
        return paymentpassword;
    }

    public void setPaymentpassword(String paymentpassword) {
        this.paymentpassword = paymentpassword;
    }

    @Basic
    @Column(name = "modifytime")
    public Timestamp getModifytime() {
        return modifytime;
    }

    public void setModifytime(Timestamp modifytime) {
        this.modifytime = modifytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(userId, account.userId) &&
                Objects.equals(useableFund, account.useableFund) &&
                Objects.equals(forzenFund, account.forzenFund) &&
                Objects.equals(totalConsumption, account.totalConsumption) &&
                Objects.equals(paymentpassword, account.paymentpassword) &&
                Objects.equals(modifytime, account.modifytime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, useableFund, forzenFund, totalConsumption, paymentpassword, modifytime);
    }
}
