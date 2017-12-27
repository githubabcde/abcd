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
@Table(name = "security_permission")
public class SecurityPermission extends EntityMasterStamped {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public SecurityPermission() {
    }
    
    public SecurityPermission(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
