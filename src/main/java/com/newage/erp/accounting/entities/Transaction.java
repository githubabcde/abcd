package com.newage.erp.accounting.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.newage.erp.core.entities.StampedNamedEntity;

/**
 *
 * @author mohammed
 */
@Entity
@Table(name = "TRANSACTION")
public class Transaction extends StampedNamedEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "TRANSACTION_TIME")
	private Date transactionTime;
	@Column(name = "TYPE")
	private Integer type;
	@ManyToOne
	@JoinColumn(name = "CURRENCY")
	private Currency currency;
	@OneToMany(mappedBy = "transaction")
	private List<TransactionDetail> transactionDetailList;

	public Transaction() {
	}

	public Transaction(Long id) {
		super(id);
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<TransactionDetail> getTransactionDetailList() {
		return transactionDetailList;
	}

	public void setTransactionDetailList(List<TransactionDetail> transactionDetailList) {
		this.transactionDetailList = transactionDetailList;
	}
}
