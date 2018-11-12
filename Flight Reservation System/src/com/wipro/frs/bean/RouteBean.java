/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:
 *
 * File Name       : RouteBean.java
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

public class RouteBean {
	
	private String routeid;
	private String source;
	private String destination;
	private int distance;
	private double fare;
	
	/**
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
	}
	/**
	 * @return source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source sr
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return distance
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * 
	 * @param destination dt
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance ds
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	/**
	 * @return fare
	 */
	public double getFare() {
		return fare;
	}
	/**
	 * @param fare fr
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}

	
	
	
	
	
	
	
	
	
	
	
}
