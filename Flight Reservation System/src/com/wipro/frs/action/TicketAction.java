package com.wipro.frs.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.bean.TicketBean;
import com.wipro.frs.dao.TicketDAO;
import com.wipro.frs.dao.TicketDAOImpl;
import com.wipro.frs.service.Customer;
import com.wipro.frs.service.CustomerImpl;

public class TicketAction extends ActionSupport implements ModelDriven{

	ArrayList<PassengerBean> list=new ArrayList<PassengerBean>();
	ArrayList<TicketBean> ticketlist=new ArrayList<TicketBean>();
	TicketDAO show=new TicketDAOImpl();
	TicketBean ticketBean=new TicketBean();
	
	private String reservationid;
	private String res_id;
	
	public String getRes_id() {
		return res_id;
	}

	/**
	 * @return the list
	 */
	public ArrayList<PassengerBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<PassengerBean> list) {
		this.list = list;
	}

	/**
	 * @return the ticketlist
	 */
	public ArrayList<TicketBean> getTicketlist() {
		return ticketlist;
	}

	/**
	 * @param ticketlist the ticketlist to set
	 */
	public void setTicketlist(ArrayList<TicketBean> ticketlist) {
		this.ticketlist = ticketlist;
	}

	/**
	 * @return the ticketBean
	 */
	public TicketBean getTicketBean() {
		return ticketBean;
	}

	/**
	 * @param ticketBean the ticketBean to set
	 */
	public void setTicketBean(TicketBean ticketBean) {
		this.ticketBean = ticketBean;
	}

	public void setRes_id(String res_id) {
		this.res_id = res_id;
	}

	public String getReservationid() {
		return reservationid;
	}

	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}

	public String execute()
	{
		String r_id=getReservationid();	
		System.out.println("rid is"+r_id);
		list=show.ticketDetails(r_id);
	System.out.println("inside execute of ticket action");
	System.out.println("this is list"+list);
		if(!list.isEmpty())
		{
	System.out.println("in if of ticket action");
			return "success";
		}
		else
		{
			System.out.println("in else of execute of tickt action");
			return "error";
		}
	}
	
	public String viewTicketsAll()
	{
		ticketlist=show.allTickets();
		System.out.println("inside view ticket");
		if(!ticketlist.isEmpty())
		{
			System.out.println("in if of view all ticket");
			System.out.println("this is t list"+ticketlist);
			return "success";
		}
		else
		{
			return "error";
		}
	}
	public String cancelTicket()
	{
		Map<String, Object> session=ActionContext.getContext().getSession();
		ReservationBean resbean=new ReservationBean();
		Customer customer=new CustomerImpl();
		String r_id=session.get(res_id);
		System.out.println("reservation id: : :"+r_id);
		boolean b=customer.cancelTicket(r_id);
		if(b==true)
		{
		return "success";
		}
		else
		{
			return "error";
		}
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
