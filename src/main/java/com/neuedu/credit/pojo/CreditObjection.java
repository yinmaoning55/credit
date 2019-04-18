package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Created by elvin on 2018/10/12 17:12.
 * @Describe:
 */
@Entity
@Table(name = "credit_objection", schema = "edu_credit", catalog = "")
public class CreditObjection {
    private static final String TAG = "CreditObjection";
    private int id;
    private int userId;
    private String entprisename;
    private String content;
    private Timestamp createtime;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "entprisename")
    public String getEntprisename() {
        return entprisename;
    }

    public void setEntprisename(String entprisename) {
        this.entprisename = entprisename;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        CreditObjection objection = (CreditObjection) o;
        return id == objection.id &&
                userId == objection.userId &&
                Objects.equals(entprisename, objection.entprisename) &&
                Objects.equals(content, objection.content) &&
                Objects.equals(createtime, objection.createtime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, entprisename, content, createtime);
    }
}
