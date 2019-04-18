package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Product
 * @Description TODO
 * @Author elvin yuan
 * @Date 2018/9/1914:26
 * @Version 1.0
 **/
@Entity
@Table(name = "product")
public class Product {
    private  int id;            //NOT NULL AUTO_INCREMENT,
    private String name;
    private String  description;   //(50) DEFAULT NULL,
    private double price;       //` decimal(10,0) DEFAULT NULL COMMENT '定价',
    private int state;              //` int(11) DEFAULT NULL,
    private Date createtime;        //` datetime DEFAULT NULL,
    private Date modifytime;    //` datetime DEFAULT NULL,

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name",unique = false,nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "description",unique = false,nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "price",unique = false,nullable = true)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Column(name = "state",unique = false,nullable = true)
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    @Column(name = "createtime",unique = false,nullable = true)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    @Column(name = "modifytime",unique = false,nullable = true)
    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }


}
