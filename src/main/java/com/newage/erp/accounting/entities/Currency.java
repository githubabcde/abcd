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
	@Column(name = "CODE", unique = true, nullable = false)
	private String code;
	@Column(name = "FRACTION", nullable = false)
	private Double fraction;

	public Currency() {

//		dbSt.execute("CREATE TABLE id(user int(8),account int(8),jrnl int(8),v int(8),band int(8),category int(8),currency int(8),unit int(8),lk int(8))");
//		dbSt.execute("INSERT INTO id VALUES(1,0,0,1,0,0,1,0,0)");
//		
//		dbSt.execute("CREATE TABLE user(id int(8),name varchar(100) UNIQUE,pass varchar(50) NOT NULL,accnt int(20),csh int(20),prjct int(20),bnd int(20),user int(20),crrncy int(20),jrnl int(20),g_v int(20),py_v int(20),rec_v int(20),dn_wrk_v int(20),str int(20),unt int(20),ctgry int(20),s_py_v int(20),s_rec_v int(20),s_exc_v int(20),lk int(20),dbm int(20),d_v int(20),PRIMARY KEY (id))");
//		dbSt.execute("INSERT INTO user VALUES(1,'MANAGER','',255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255,255)");
//
//		dbSt.execute("CREATE TABLE currency(id int(3),name varchar(50) UNIQUE,code varchar(10) UNIQUE,fraction double(9,4) DEFAULT NULL,PRIMARY KEY (id))");
//		dbSt.execute("INSERT INTO currency VALUES(1,'ريال يمني','YR',1)");
//
//		dbSt.execute("CREATE TABLE account(id int(8),super_id int(8),name varchar(100) UNIQUE,currency_id int(8),strt_amnt double(20,4) DEFAULT 0,strt_amnt_frgn double(20,4) DEFAULT 0,PRIMARY KEY (id),FOREIGN KEY (super_id) REFERENCES account(id),FOREIGN KEY (currency_id) REFERENCES currency(id))");
//		dbSt.execute("CREATE TABLE cash(id int(8),PRIMARY KEY (id),FOREIGN KEY (id) REFERENCES account(id))");
//
//		dbSt.execute("CREATE TABLE project(id int(8),PRIMARY KEY (id),FOREIGN KEY (id) REFERENCES account(id))");
//		dbSt.execute("CREATE TABLE band(id int(8),project_id int(8),name varchar(100),s_id int(8),strt_amnt double(20,4) DEFAULT 0,PRIMARY KEY (id),FOREIGN KEY (project_id) REFERENCES project(id),FOREIGN KEY (s_id) REFERENCES band(id))");
//
//		dbSt.execute("CREATE TABLE jrnl(id int(8),date date,name varchar(100),lkd enum('lk','ulk') NOT NULL,PRIMARY KEY (id))");
//		dbSt.execute("CREATE TABLE v(id int(8) NOT NULL,currency_id int(8)NOT NULL,amount double(12,2) NOT NULL,in_am double(12,2) NOT NULL,dbt_am double(12,2) NOT NULL,crdt_am double(12,2) NOT NULL,date date NOT NULL,descr varchar(100) NOT NULL,crdt_accnt_id int(8) NOT NULL,dbt_accnt_id int(8) NOT NULL,jrnl_id int(8),ref_type int(8)NOT NULL,user_id int(8) NOT NULL,dbt_bnd_id INT(8),crdt_bnd_id int(8),mnl_id INT(8),PRIMARY KEY (id),FOREIGN KEY (currency_id) REFERENCES currency(id),FOREIGN KEY (crdt_accnt_id) REFERENCES account(id),FOREIGN KEY (dbt_accnt_id) REFERENCES account(id),FOREIGN KEY (jrnl_id) REFERENCES jrnl(id),FOREIGN KEY (user_id) REFERENCES user(id),FOREIGN KEY (dbt_bnd_id) REFERENCES band(id),FOREIGN KEY (crdt_bnd_id) REFERENCES band(id))");
//		dbSt.execute("CREATE TABLE d_v(id int(8) NOT NULL,amount double(12,2) NOT NULL,in_am double(12,2) NOT NULL,date date NOT NULL,descr varchar(100) NOT NULL,crdt_accnt_id int(8) NOT NULL,dbt_accnt_id int(8) NOT NULL,ref_type int(8)NOT NULL,user_id int(8) NOT NULL,d_user_id int(8) NOT NULL,jrnl_id int(8))");
//		dbSt.execute("CREATE TABLE done_work(v_id int(8) UNIQUE,unit varchar(20),quantitiy double(8,2) NOT NULL,cost double(12,2) NOT NULL,FOREIGN KEY (v_id) REFERENCES v(id))");
//		dbSt.execute("CREATE TABLE v_nm(v_id INT(3),name VARCHAR(100),FOREIGN KEY (V_id) REFERENCES v(id))");
//
//		dbSt.execute("CREATE TABLE unit(id int(8)NOT NULL,name varchar(100)NOT NULL UNIQUE,smbl varchar(100)NOT NULL UNIQUE,PRIMARY KEY (id))");
//		dbSt.execute("CREATE TABLE category(id int(8)NOT NULL,name varchar(100)NOT NULL,unit int(8)NOT NULL,FOREIGN KEY (unit) REFERENCES unit(id),PRIMARY KEY (id))");
//		dbSt.execute("CREATE TABLE store(id int(8)NOT NULL,project_id int(8),PRIMARY KEY (id),FOREIGN KEY (id) REFERENCES account(id))");
//		dbSt.execute("CREATE TABLE s_v(v_id int(8),cat_id int(8)NOT NULL,qua double(8,2) NOT NULL,cost double(12,2) NOT NULL,FOREIGN KEY (v_id) REFERENCES v(id),FOREIGN KEY (cat_id) REFERENCES category(id))");
//		dbSt.execute("CREATE TABLE str_strt_amnt(str_id int(8),ctgry_id int(8),strt_qnt double(20,4)DEFAULT 0,FOREIGN KEY (str_id) REFERENCES account(id),FOREIGN KEY (ctgry_id) REFERENCES category(id))");
//
//		dbSt.execute("CREATE TABLE lk(id int(8),name varchar(100) UNIQUE,date date NOT NULL,lkd enum('lk','ulk') NOT NULL,PRIMARY KEY (id))");
//
//		dbSt.execute("CREATE TABLE var(version varchar(20),f_year int(4))");
//		dbSt.execute("INSERT INTO var(version,f_year)VALUES('" + MainFrame.version + "',2011)");

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
