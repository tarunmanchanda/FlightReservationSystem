package com.wipro.frs.service;

import java.util.Date;
import java.util.ArrayList;

import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.bean.ScheduleBean;

public interface Customer {

	ArrayList<ScheduleBean> viewScheduleByRoute(String source, String destination, Date date);
	String reserveTicket(ReservationBean reservationBean, ArrayList<PassengerBean> passengers);
	boolean cancelTicket(String reservationId);
	
	
}