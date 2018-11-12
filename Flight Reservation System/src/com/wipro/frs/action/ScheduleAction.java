/*
 *
 *@Copyright 2015 Wipro Technologies All rights reserved.
 * 
 *@Customer specific copyright notice:aASD09
 *
 *@File Name       : FlightAction.java
 *
 *@Description     :Project desc.
 *
 *@Version         : 1.0.0
 *
 *@Created Date    :Apr 3, 2015
 * 
 */
package com.wipro.frs.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import com.wipro.frs.bean.ScheduleBean;
import com.wipro.frs.service.Administrator;
import com.wipro.frs.service.AdministratorImpl;

/**
 * 
 * @author TARUN MANCHANDA
 * @author AASHISH
 * @version 1.0
 * @since 1.0 Date : Apr 3, 2015
 */
public class ScheduleAction implements ModelDriven {

	private ScheduleBean scheduleBean=new ScheduleBean();
	private ArrayList<ScheduleBean> scheduleList;
	private String abc;
	private ArrayList<String> deleteid=new ArrayList<String>();
	
	/**
	 * @return scheduleList
	 */
	public ArrayList<ScheduleBean> getScheduleList() {
		return scheduleList;
	}
	/**
	 * @param scheduleList sl
	 */
	public void setScheduleList(ArrayList<ScheduleBean> scheduleList) {
		this.scheduleList = scheduleList;
	}
	/**
	 * @return scheduleBean
	 */
	public ScheduleBean getScheduleBean() {
		return scheduleBean;
	}
	/**
	 * @param scheduleBean sb
	 */
public void setScheduleBean(ScheduleBean scheduleBean) {
		this.scheduleBean = scheduleBean;
	}
/** 
 * @see com.opensymphony.xwork2.ActionSupport#execute()
 * @return pageaction
 */
public String execute()
	{
		Map<String, Object> session=ActionContext.getContext().getSession();
		Administrator schedule =new AdministratorImpl();
	
		String sid=schedule.addSchedule(scheduleBean);
		System.out.println("in execute");
		if(!"error".equals(sid))
		{
			session.put("scheduleID", sid);
			return "success";
		}
	
		return "error";
	}
/**
 * 
 * @return String
 */
public String viewAllschedule() {
	Administrator showschedule = new AdministratorImpl();

	scheduleList = showschedule.viewByAllSchedule();

	if (scheduleList.isEmpty()) {
		return "error";
	} else {
		return "success";
	}
	

}

public String getAbc() {
	return abc;
}
public void setAbc(String abc) {
	this.abc = abc;
}
public ArrayList<String> getDeleteid() {
	return deleteid;
}
public void setDeleteid(ArrayList<String> deleteid) {
	this.deleteid = deleteid;
}
@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return scheduleBean;
	}
	
/**
 * 
 * @return String
 */

public String viewSchedulebyId() {
	Administrator showschedulebyid = new AdministratorImpl();
	scheduleBean = showschedulebyid.viewByScheduleId(scheduleBean.getScheduleid());
	return "success";
}
public String editSchedule()
{
	System.out.println("in the edit methodof route");
	Administrator editschedule=new AdministratorImpl();
	boolean a=editschedule.modifySchedule(scheduleBean);
	System.out.println("the returned value is "+a);
	if(a)
	{  
		viewAllschedule();
		return "success";
	}
	else
		{
		return "error";
		}
}

public String scheduleDelete()
{   deleteid.add(this.getAbc());
	Administrator admin =new AdministratorImpl();
	int result =admin.removeSchedule(deleteid);
	System.out.println(result);
	if(result==1)
	{	
		System.out.println("in if actrion");
		viewAllschedule();
	return "success";
	}
	else
	{
		return "error";
	}
}
}
