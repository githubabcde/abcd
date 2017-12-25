package com.newage.erp.entities;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author mohammed
 */
public class EntityMaster {
    @Id
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
