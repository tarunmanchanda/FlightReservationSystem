package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;

public interface ReservationDAO {

	String reserveTicket(ReservationBean reservationBean,
			ArrayList<PassengerBean> passengers);

	public ArrayList<PassengerBean> viewPassengers(String scheduleid);
	
	
	
	
	
	
}
