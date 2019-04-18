package com.neuedu.credit.pojo;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Created by elvin on 2018/9/21 10:23.
 * @Describe:
 */
@Entity
@Table(name = "user_role", schema = "edu_credit", catalog = "")
public class UserRole {
    private static final String TAG = "UserRole";
    private int id;
    private Integer rolId;
    private Integer userId;

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
    @Column(name = "rol_id")
    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id &&
                Objects.equals(rolId, userRole.rolId) &&
                Objects.equals(userId, userRole.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, rolId, userId);
    }
}
