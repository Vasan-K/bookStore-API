package com.bookstore.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_wallet")
public class Wallet {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	
	private double userAmt;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public double getUserAmt() {
		return userAmt;
	}

	public void setUserAmt(double userAmt) {
		this.userAmt = userAmt;
	}
	
	
}
