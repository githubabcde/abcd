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
@Table(name = "security_group")
public class SecurityGroup extends EntityMasterStamped {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public SecurityGroup() {
    }

    public String getName() {
        return name;
    }
    
    public SecurityGroup(Long id) {
        super(id);
    }

    public void setName(String name) {
        this.name = name;
    }
}
