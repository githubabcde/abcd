package com.newage.erp.entities.security;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "erpGroup")
public class ErpGroup implements Serializable {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @JoinColumn(name = "stampUser")
    @ManyToOne
    private ErpUser stampUser;
    @Column(name = "stampTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stampTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ErpUser getStampUser() {
        return stampUser;
    }

    public void setStampUser(ErpUser stampUser) {
        this.stampUser = stampUser;
    }

    public Date getStampTime() {
        return stampTime;
    }

    public void setStampTime(Date stampTime) {
        this.stampTime = stampTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ErpGroup)) {
            return false;
        }
        ErpGroup other = (ErpGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.newage.erp.entities.Caller[ id=" + id + " ]";
    }

}
