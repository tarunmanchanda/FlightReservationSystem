package com.wipro.frs.dao;

import java.util.ArrayList;

import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.TicketBean;

public interface TicketDAO {

	
	
	
	public ArrayList<TicketBean> allTickets();

	public ArrayList<PassengerBean> ticketDetails(String r_id);

	public boolean removeTicket(String reservationId);;
}
