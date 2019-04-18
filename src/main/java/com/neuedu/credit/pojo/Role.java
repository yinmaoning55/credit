package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:22.
 * @Describe:
 */
@Entity
@Table(name = "role", schema = "edu_credit", catalog = "")
public class Role implements Serializable{
    private static final String TAG = "Role";
    private int id;
    private String name;
    private String enName;
    private String description;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "en_name")
    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name) &&
                Objects.equals(enName, role.enName) &&
                Objects.equals(description, role.description) &&
                Objects.equals(createtime, role.createtime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, enName, description, createtime);
    }
}
