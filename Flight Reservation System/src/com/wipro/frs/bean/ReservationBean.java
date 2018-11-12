package com.wipro.frs.bean;

import java.util.Date;

public class ReservationBean {

	private String reservationid;
	private String userid;
	private String scheduleid;
	private String reservationtype;
	private Date bookingdate;
	private Date journeydate;
	private int noofseats;
	private Double totalfare;
	private int bookingstatus;
	public String getReservationid() {
		return reservationid;
	}
	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getScheduleid() {
		return scheduleid;
	}
	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}
	public String getReservationtype() {
		return reservationtype;
	}
	public void setReservationtype(String reservationtype) {
		this.reservationtype = reservationtype;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public Date getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(Date journeydate) {
		this.journeydate = journeydate;
	}
	public int getNoofseats() {
		return noofseats;
	}
	public void setNoofseats(int noofseats) {
		this.noofseats = noofseats;
	}
	public Double getTotalfare() {
		return totalfare;
	}
	public void setTotalfare(Double totalfare) {
		this.totalfare = totalfare;
	}
	public int getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(int bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
	
	
	
	
	
	
}
