/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:
 *
 * File Name       : FlightBean.java
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
public class FlightBean {

	
	
	private String flightid;
	private String flightname;
	private int seatingcapacity;
	private int reservationcapacity;
	
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
	}
	/**
	 * @return flightname
	 */
	public String getFlightname() {
		return flightname;
	}
	/**
	 * @param flightname fn
	 */
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	/**
	 * @return seatingcapacity
	 */
	public int getSeatingcapacity() {
		return seatingcapacity;
	}
	
	/**
	 * @param seatingcapacity sc
	 */
	 public void setSeatingcapacity(int seatingcapacity) {
			this.seatingcapacity = seatingcapacity;
		}
		
	 /**
		 * @return reservationcapacity
		 */
	 public int getReservationcapacity() {
		return reservationcapacity;
	}
	 /**
		 * @param reservationcapacity rc
		 */
		 public void setReservationcapacity(int reservationcapacity) {
			this.reservationcapacity = reservationcapacity;
		}
	
	
	
	
	
}
