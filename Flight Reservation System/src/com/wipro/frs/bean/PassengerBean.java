package com.wipro.frs.bean;

public class PassengerBean {

	private String reservationid;
	private String name;
	private String gender;
	private int age;
	private int seatno;
	private String scheduleid;
	/**
	 * @return the scheduleid
	 */
	public String getScheduleid() {
		return scheduleid;
	}
	/**
	 * @param scheduleid the scheduleid to set
	 */
	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}
	public String getReservationid() {
		return reservationid;
	}
	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSeatno() {
		return seatno;
	}
	public void setSeatno(int seatno) {
		this.seatno = seatno;
	}
	
	
	
	
	
	
}
