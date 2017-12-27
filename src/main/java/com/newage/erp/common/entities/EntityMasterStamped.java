package com.newage.erp.common.entities;

import com.newage.erp.security.entities.SecurityUser;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mohammed
 */
@MappedSuperclass
public class EntityMasterStamped extends EntityMaster {

    @Column(name = "stamp_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date stampTime;
    @JoinColumn(name = "stamp_user", nullable = false)
    @ManyToOne
    protected SecurityUser stampUser;

    public EntityMasterStamped() {
    }

    public EntityMasterStamped(Long id) {
        super(id);
    }

    public Date getStampTime() {
        return stampTime;
    }

    public void setStampTime(Date stampTime) {
        this.stampTime = stampTime;
    }

    public SecurityUser getStampUser() {
        return stampUser;
    }

    public void setStampUser(SecurityUser stampUser) {
        this.stampUser = stampUser;
    }
}
