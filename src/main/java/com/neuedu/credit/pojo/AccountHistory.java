package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "account_history", schema = "edu_credit", catalog = "")
public class AccountHistory {
    private static final String TAG = "AccountHistory";
    private long id;
    private Integer accId;
    private Integer money;
    private Integer hisType;
    private String hisWho;
    private Long orderId;
    private Timestamp createtime;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "acc_id")
    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    @Basic
    @Column(name = "money")
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "his_type")
    public Integer getHisType() {
        return hisType;
    }

    public void setHisType(Integer hisType) {
        this.hisType = hisType;
    }

    @Basic
    @Column(name = "his_who")
    public String getHisWho() {
        return hisWho;
    }

    public void setHisWho(String hisWho) {
        this.hisWho = hisWho;
    }

    @Basic
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
        AccountHistory that = (AccountHistory) o;
        return id == that.id &&
                Objects.equals(accId, that.accId) &&
                Objects.equals(money, that.money) &&
                Objects.equals(hisType, that.hisType) &&
                Objects.equals(hisWho, that.hisWho) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accId, money, hisType, hisWho, orderId, createtime);
    }
}
