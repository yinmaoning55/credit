package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "order_product", schema = "edu_credit", catalog = "")
public class OrderProduct {
    private static final String TAG = "OrderProduct";
    private int id;
    private String orderno;
    private Integer pid;
    private Integer count;
    private Double unitprice;

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
    @Column(name = "orderno")
    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    @Basic
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "unitprice")
    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProduct that = (OrderProduct) o;
        return id == that.id &&
                Objects.equals(orderno, that.orderno) &&
                Objects.equals(pid, that.pid) &&
                Objects.equals(count, that.count) &&
                Objects.equals(unitprice, that.unitprice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderno, pid, count, unitprice);
    }
}
