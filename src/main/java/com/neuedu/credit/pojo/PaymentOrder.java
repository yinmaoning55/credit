package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "payment_order", schema = "edu_credit", catalog = "")
public class PaymentOrder {
    private static final String TAG = "PaymentOrder";
    private String orderno;
    private Integer userId;
    private double amount;
    private Integer status;
    private Timestamp createtime;
    private String userIp;
    private Integer shippingType;
    private Integer payType;
    private Timestamp donetime;

    @Id
    @Column(name = "orderno")
    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
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
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "user_ip")
    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Basic
    @Column(name = "shipping_type")
    public Integer getShippingType() {
        return shippingType;
    }

    public void setShippingType(Integer shippingType) {
        this.shippingType = shippingType;
    }

    @Basic
    @Column(name = "pay_type")
    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "donetime")
    public Timestamp getDonetime() {
        return donetime;
    }

    public void setDonetime(Timestamp donetime) {
        this.donetime = donetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentOrder that = (PaymentOrder) o;
        return orderno == that.orderno &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(userIp, that.userIp) &&
                Objects.equals(shippingType, that.shippingType) &&
                Objects.equals(payType, that.payType) &&
                Objects.equals(donetime, that.donetime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderno, userId, amount, status, createtime, userIp, shippingType, payType, donetime);
    }
}
