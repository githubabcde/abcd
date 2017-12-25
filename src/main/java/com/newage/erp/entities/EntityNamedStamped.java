package com.newage.erp.entities;

import com.newage.erp.entities.security.Caller;
import java.util.Date;
import javax.persistence.Column;

/**
 *
 * @author mohammed
 */
public class EntityNamedStamped extends EntityNamed {

    @Column(name = "user")
    protected Caller caller;
    @Column(name = "timeStamp")
    protected Date timeStamp;

    public EntityNamedStamped(Long id) {
        super(id);
    }

    public Caller getCaller() {
        return caller;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
