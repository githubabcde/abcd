package com.newage.erp.entities.security;

import com.newage.erp.entities.EntityNamedStamped;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author mohammed
 */
@Table(name = "caller")
public class Caller extends EntityNamedStamped {
    
    @Column(name="password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Caller)) {
            return false;
        }
        Caller other = (Caller) object;
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
