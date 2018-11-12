package com.wipro.frs.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.wipro.frs.bean.PassengerBean;
import com.wipro.frs.bean.ReservationBean;
import com.wipro.frs.service.Administrator;
import com.wipro.frs.service.AdministratorImpl;
import com.wipro.frs.service.Customer;
import com.wipro.frs.service.CustomerImpl;

public class AddPassengerAction {
	PassengerBean passengerBean=new PassengerBean();
	ReservationBean reservationBean=new ReservationBean();
	private static ArrayList<PassengerBean> passengerlist;
	private String name;
	private String gender;
	private int age;
	private double fared;
	private double calcfare;
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



	static{
		passengerlist=new ArrayList();
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



		/**
		 * @return the calcfare
		 */
		public double getCalcfare() {
			return calcfare;
		}



		/**
		 * @param calcfare the calcfare to set
		 */
		public void setCalcfare(double calcfare) {
			this.calcfare = calcfare;
		}



		public static void setPassengerlist(ArrayList<PassengerBean> passengerlist) {
			AddPassengerAction.passengerlist = passengerlist;
		}



		public String execute()
		{
			Map<String, Object> session=ActionContext.getContext().getSession();
			passengerBean.setName(name);
			passengerBean.setGender(gender);
			passengerBean.setAge(age);
			passengerlist.add(passengerBean);
			int size1=passengerlist.size();
			System.out.println("size of the pass list is"+size1);
			double totalamount=((Double) session.get("calcfare"))*size1;
			System.out.println("in execute of add passenger action and the total amount is "+totalamount);
			session.put("totalamount", totalamount);
			
			session.put("passengerlist", passengerlist);
			if(!(passengerlist.isEmpty()))
			{
			//viewPassenger();
			return "success";
			}
			return "success";
		
		}
	//	public String viewPassenger()
		//{
			//if(!(passengerlist.isEmpty()))
			//{
				//return "success";
			//}
			//else
			//{
				//return "error";
			//}
		//}
		public String reserve()
		{
			Map<String, Object> session=ActionContext.getContext().getSession();
			session.put("fare",getFared());
			System.out.println("inside reserve method add pass action fare is "+session.get("fare"));
			return "success";
			
		}
		public String donePassenger()
		{
			Customer customer=new CustomerImpl();
			customer.reserveTicket(new ReservationBean(),passengerlist);
			
				return "success";
		}
		public String executeViewPassenger()
		{
			if(scheduleid!=null)
			{
				Map<String, Object> session=ActionContext.getContext().getSession();
				session.put("scheduleid", scheduleid);
				Administrator viewPassenger=new AdministratorImpl();
				passengerlist=viewPassenger.viewPasengersBySchedule(scheduleid);
				if(passengerlist.size()>0)
				{
					System.out.println("the system values are"+session.get("reservationss"));
					return "success";
				}
				else
				{
					return "fail";
				}
			}
			return "failed";
		}
		
	

		
		public PassengerBean getPassengerBean() {
			return passengerBean;
		}
		public void setPassengerBean(PassengerBean passengerBean) {
			this.passengerBean = passengerBean;
		}
		public ReservationBean getReservationBean() {
			return reservationBean;
		}
		public void setReservationBean(ReservationBean reservationBean) {
			this.reservationBean = reservationBean;
		}
		public ArrayList<PassengerBean> getPassengerlist() {
			return passengerlist;
		}
		public void setPlist(ArrayList<PassengerBean> passengerlist) {
			this.passengerlist = passengerlist;
		}



		public void setFared(double fared) {
			this.fared = fared;
		}



		public double getFared() {
			return fared;
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

