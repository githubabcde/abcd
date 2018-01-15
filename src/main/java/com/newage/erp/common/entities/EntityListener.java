package com.newage.erp.common.entities;

import com.newage.erp.security.entities.SecurityUser;
import java.util.Date;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author mohammed
 */
public class EntityListener {

    @PrePersist
    public void preCreate(EntityMasterStamped entity) {
        entity.setCreateTime(new Date());
        entity.setCreateUser(new SecurityUser(1l));
    }

    @PreUpdate
    public void preUpdate(EntityMasterStamped entity) {
        entity.setUpdateTime(new Date());
        entity.setUpdateUser(new SecurityUser(1l));
    }
}
