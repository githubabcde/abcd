package com.newage.erp.entities;

import javax.persistence.Column;

/**
 *
 * @author mohammed
 */
public class EntityNamed extends EntityMaster {


    @Column(name = "name", unique = true)
    protected String name;

    public EntityNamed(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
