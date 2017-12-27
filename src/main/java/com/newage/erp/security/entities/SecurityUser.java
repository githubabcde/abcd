package com.newage.erp.security.entities;

import com.newage.erp.common.entities.EntityMasterStamped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "security_user")
public class SecurityUser extends EntityMasterStamped {

    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "password")
    private String password;

    public SecurityUser() {
    }

    public SecurityUser(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
