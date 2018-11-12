package com.wipro.frs.service;

import java.util.Date;
import java.util.ArrayList;

import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.dao.CustomerDAOImpl;
import com.wipro.frs.dao.ReservationDAO;
import com.wipro.frs.dao.ReservationDAOImpl;
import com.wipro.frs.dao.TicketDAO;
import com.wipro.frs.dao.TicketDAOImpl;

public class CustomerImpl implements Customer {
 private Date date;
 
	public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

	@Override
	public boolean cancelTicket(String reservationId) {
		// TODO Auto-generated method stub
		
		TicketDAO show=new TicketDAOImpl();
		boolean res= show.removeTicket(reservationId);
		if(res==true)
		{
		return true;
		}
		return false;
	}
		
	

	@Override
	public String reserveTicket(ReservationBean reservationBean,
			ArrayList<PassengerBean> passengers) {
		// TODO Auto-generated method stub
		
		
		ReservationDAO reservationDAO=new ReservationDAOImpl();
		return reservationDAO.reserveTicket(reservationBean, passengers);
	
	}

	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String source,
			String destination, Date date) {
		// TODO Auto-generated method stub
	
			ArrayList<ScheduleBean> scheduleList=new ArrayList<ScheduleBean>();
			CustomerDAOImpl schedulebyroute=new CustomerDAOImpl();
			scheduleList=schedulebyroute.viewScheduleByRoute(source, destination, date);
			if(scheduleList.isEmpty())
			{
				System.out.println("is empty");
				return null;
			}
			
			return scheduleList;
			
		}

}
	


