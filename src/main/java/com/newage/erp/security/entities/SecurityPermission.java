package com.newage.erp.security.entities;

import com.newage.erp.common.entities.StampedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "SECURITY_PERMISSION")
public class SecurityPermission extends StampedEntity {

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    
    @Column(name = "PERMISSION", unique = true, nullable = false)
    private String permission;
    
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
