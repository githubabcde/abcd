package com.newage.erp.common.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author mohammed
 */
@MappedSuperclass
public class SupperEntity implements Serializable {

    @Id
    @Column(name = "ID")
    protected Long id;

    public SupperEntity() {
    }

    public SupperEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
