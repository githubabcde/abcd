package com.newage.erp.accounting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.newage.erp.core.entities.StampedEntity;

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
	@Column(name = "CODE", unique = true, nullable = false)
	private String code;
	@Column(name = "FRACTION", nullable = false)
	private Double fraction;

	public Currency() {
	}

	public Currency(Long id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getFraction() {
		return fraction;
	}

	public void setFraction(Double fraction) {
		this.fraction = fraction;
	}
}
