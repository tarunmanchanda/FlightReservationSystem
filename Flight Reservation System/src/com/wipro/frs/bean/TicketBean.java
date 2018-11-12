package com.wipro.frs.bean;

import java.sql.Date;

public class TicketBean {

	private String reservationid;
	private Date journeydate;
	private int noofseats;
	private String source;
	private String destination;
	
	
	
	/**
	 * @return the reservationid
	 */
	public String getReservationid() {
		return reservationid;
	}
	/**
	 * @param reservationid the reservationid to set
	 */
	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}
	/**
	 * @return the journeydate
	 */
	public Date getJourneydate() {
		return journeydate;
	}
	/**
	 * @param journeydate the journeydate to set
	 */
	public void setJourneydate(Date journeydate) {
		this.journeydate = journeydate;
	}
	/**
	 * @return the noofseats
	 */
	public int getNoofseats() {
		return noofseats;
	}
	/**
	 * @param noofseats the noofseats to set
	 */
	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
}



