package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Created by elvin on 2018/9/26 15:20.
 * @Describe:
 */
@Entity
@Table(name = "verificationcode")
public class VerificationCode {

    private int id;
    private String verifycode;
    private String sendto;
    private int usedfor;
    private Timestamp expired;

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "verifycode")
    public String getVerifyCode() {
        return verifycode;
    }

    public void setVerifyCode(String verifycode) {
        this.verifycode = verifycode;
    }
    @Column(name = "sendto",nullable = false)
    public String getSendTo() {
        return sendto;
    }

    public void setSendTo(String sendto) {
        this.sendto = sendto;
    }
    @Column(name = "usedfor",nullable = false)
    public int getUsedfor() {
        return usedfor;
    }

    public void setUsedfor(int usedfor) {
        this.usedfor = usedfor;
    }
    @Column(name = "expired",nullable = false)
    public Timestamp getExpired() {
        return expired;
    }

    public void setExpired(Timestamp expired) {
        this.expired = expired;
    }
}
