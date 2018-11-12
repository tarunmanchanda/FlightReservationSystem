/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:
 *
 * File Name       :CreditCardBean.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :Apr 3, 2015
 * 
 */
package com.wipro.frs.bean;
/**
*
* @author-1 TARUN MANCHANDA
* @author-2 AASHISH
* @version 1.0 
* @since 1.0
* Date : Apr 3, 2015
*/
public class CreditCardBean {
	private String creditcardnumber;
	private String validfrom;
	private String validto;
	private double creditbalance;
	private String userid;
	/**
	 * @return creditcardnumber
	 */
	public String getCreditcardnumber() {
		return creditcardnumber;
	}
	/**
	 * @param creditcardnumber cc
	 */
	public void setCreditcardnumber(String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}
	/**
	 * @return validfrom
	 */
	public String getValidfrom() {
		return validfrom;
	}
	/**
	 * @param validfrom vf
	 */
	public void setValidfrom(String validfrom) {
		this.validfrom = validfrom;
	}
	/**
	 * @return validto
	 */
	public String getValidto() {
		return validto;
	}
	/**
	 * @param validto vt
	 */
	public void setValidto(String validto) {
		this.validto = validto;
	}
	/**
	 * @return creditbalance
	 */
	
	/**
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @return the creditbalance
	 */
	public double getCreditbalance() {
		return creditbalance;
	}
	/**
	 * @param creditbalance the creditbalance to set
	 */
	public void setCreditbalance(double creditbalance) {
		this.creditbalance = creditbalance;
	}
	/**
	 * @param userid ud
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}


}
