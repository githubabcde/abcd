package com.newage.erp.accounting.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.newage.erp.common.entities.StampedEntity;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "ACCOUNT")
public class Account extends StampedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;
	@Column(name = "CODE", unique = true, nullable = false)
	private String code;
	@ManyToOne
	@JoinColumn(name = "CURRENCY")
	private Currency currency;
	@ManyToOne
	@JoinColumn(name = "PARINT")
	private Account parint;

	public Account() {
	}

	public String getName() {
		return name;
	}

	public Account(Long id) {
		super(id);
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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Account getParint() {
		return parint;
	}

	public void setParint(Account parint) {
		this.parint = parint;
	}
}
