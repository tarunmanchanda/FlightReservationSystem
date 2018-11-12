/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:rW2
 *
 * File Name       : FlightAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :Apr 3, 2015
 * 
 */
package com.wipro.frs.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.wipro.frs.bean.FlightBean;
import com.wipro.frs.service.Administrator;
import com.wipro.frs.service.AdministratorImpl;
/**
 * 
 * @author TARUN MANCHANDA
 * @author AASHISH
 * @version 1.0
 * @since 1.0 Date : Apr 3, 2015
 */
	public class FlightAction implements ModelDriven{
	private ArrayList<FlightBean> flightList;

	private String abc;
	private ArrayList<String> deleteid=new ArrayList<String>();
	private FlightBean flightBean= new FlightBean();
	private String fid;
	
	/**
	 * @return flightList
	 */
	public ArrayList<FlightBean> getFlightList() {
		return flightList;
	}
	/**
	 * @param flightList fl
	 */
	public void setFlightList(ArrayList<FlightBean> flightList) {
		this.flightList = flightList;
		}
	
	@Override
	public Object getModel() {
		return flightBean;
	} 
	/**
	 * @return flightBean
	 */
	public FlightBean getFlightBean() {
		return flightBean;
	}
	/**
	 * @param flightBean1 fb
	 */
	public void setFlightBean(FlightBean flightBean1) {
		this.flightBean = flightBean1;
	}
	/**
	 * @return fid
	 */
	public String getFid() {
		return fid;
	}
	/**
	 * @param fid1 fd1
	 */
	public void setFid(String fid1) {
		this.fid = fid1;
	}
	

/** 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @return pageaction
	 */
	public String execute()
	{
		Map<String, Object> session=ActionContext.getContext().getSession();
		Administrator flight =new AdministratorImpl();
		String fid=flight.addFlight(flightBean);
		if(!"error".equals(fid))
		{
			session.put("flightID", fid);
			return "success";
		}
	
		return "error";
	}
	/**
	 * 
	 * @return String
	 */
	public String viewAllflights() {
		AdministratorImpl showdetail = new AdministratorImpl();

		flightList = showdetail.viewByAllFlights();

		if (flightList.isEmpty()) {
			return "error";
		} else {
			return "success";
		}

	}
	/**
	 * @return String
	 */
	public String viewFlightsbyId() {
		Administrator showflightbyid = new AdministratorImpl();
		flightBean = showflightbyid.viewByFlightId(flightBean.getFlightid());
		return "success";
	}

	/**
	 * 
	 * @return String
	 */
	public String editFlight()
	{
		System.out.println("in the edit method");
		Administrator editflight=new AdministratorImpl();
		boolean a=editflight.modifyFlight(flightBean);
		System.out.println("the returned value is "+a);
		if(a)
		{

			viewAllflights();

			return "success";
		}

		{
			return "error";
	}
		}
	
	/**
	 * 
	 * @return String
	 */
	public String flightDelete()
	{   deleteid.add(this.getAbc());
		Administrator admin =new AdministratorImpl();
		int result =admin.removeFlight(deleteid);
		System.out.println(result);
		if(result==1)
		{	
			viewAllflights();
		return "success";
		}
		else
		{
			return "error";
		}
	}
	/**
	 * @return abc
	 */
	public String getAbc() {
		return abc;
	}
	/**
	 * @param abc abc
	 */
	public void setAbc(String abc) {
		this.abc = abc;
	}
	/**
	 * @return deleteid 
	 */
	public ArrayList<String> getDeleteid() {
		return deleteid;
	}
	/**
	 * @param deleteid did
	 */
	public void setDeleteid(ArrayList<String> deleteid) {
		this.deleteid = deleteid;
	}
	
}
	


