package com.newage.erp.accounting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.newage.erp.common.entities.StampedEntity;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "CURRENCY")
public class Currency extends StampedEntity {

	private static final long serialVersionUID = 1L;
	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	public Currency() {
	}

	public String getName() {
		return name;
	}

	public Currency(Long id) {
		super(id);
	}

	public void setName(String name) {
		this.name = name;
	}
}
