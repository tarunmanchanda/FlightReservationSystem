/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:
 *
 * File Name       : ScheduleBean.java
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
public class ScheduleBean {
	private String scheduleid;
	private String flightid;
	private String routeid;
	private int travelduration;
	private String availabledays;
	private int departuretime;
	
	/**
	 * @return scheduleid
	 */
	public String getScheduleid() {
		return scheduleid;
	}
	/**
	 * @param scheduleid sd
	 */
	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}
	/**
	 * @return flightid
	 */
	public String getFlightid() {
		return flightid;
	}
	/**
	 * @param flightid fd
	 */
	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}/**
	 * @return routeid
	 */
	public String getRouteid() {
		return routeid;
	}
	/** 
	 * @param routeid rd
	 */
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}/**
	 * @return travelduration
	 */
	public int getTravelduration() {
		return travelduration;
	}
	/**
	 * @param travelduration td
	 */
	public void setTravelduration(int travelduration) {
		this.travelduration = travelduration;
	}
	/**
	 * @return availabledays
	 */
	public String getAvailabledays() {
		return availabledays;
	}
	/**
	 * @param availabledays ad
	 */
	public void setAvailabledays(String availabledays) {
		this.availabledays = availabledays;
	}
	/**
	 * @return departuretime
	 */
	public int getDeparturetime() {
		return departuretime;
	}
	/**
	 * @param departuretime dr
	 */
	public void setDeparturetime(int departuretime) {
		this.departuretime = departuretime;
	}
	
	
	

}
