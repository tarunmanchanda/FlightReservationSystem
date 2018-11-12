/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:
 *
 * File Name       : ProfileBean.java
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
import java.sql.Date;
public class ProfileBean {
	private String userid;
	private String firstname;
	private String lastname;
	private Date dateofbirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobilenumber;
	private String emailid;
	private String password;
	
	/**
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname 
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname 
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return dateofbirth 
	 */
	public Date getDateofbirth() {
		return dateofbirth;
	}
	/**
	 * @param dateofbirth  
	 */
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	/**
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender 
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street  
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return location 
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location 
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state 
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return pincode
	 */
	public String getPincode() {
		return pincode;
	}
	/**
	 * @param pincode 
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return mobilenumber
	 */
	public String getMobilenumber() {
		return mobilenumber;
	}
	/**
	 * @param mobilenumber 
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	/**
	 * @return emailid 
	 */
	public String getEmailid() {
		return emailid;
	}
	/**
	 * @param emailid 
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
