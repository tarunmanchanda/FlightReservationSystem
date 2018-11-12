/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     : 
 *
 * File Name       : RouteAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :April 17, 2015
 * 
 */
package com.wipro.frs.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import com.wipro.frs.bean.RouteBean;
import com.wipro.frs.service.Administrator;
import com.wipro.frs.service.AdministratorImpl;

/**
 * 
 * @author TARUN MANCHANDA
 * @author AASHISH
 * @version 1.0
 * @since 1.0 Date : Apr 3, 2015
 */
public class RouteAction implements ModelDriven{
	private ArrayList<RouteBean> routeList;
	private String routeid;
	private String abc;
	private ArrayList<String> deleteid=new ArrayList<String>();
	private RouteBean routeBean=new RouteBean();
	
	
	
	/**
	 * @return routeList
	 */
	public ArrayList<RouteBean> getRouteList() {
		return routeList;
	}
	/**
	 * @param routeList rl
	 */

	public void setRouteList(ArrayList<RouteBean> routeList) {
		this.routeList = routeList;
	}
	/**
	 * @return routeBean
	 */
	public RouteBean getRouteBean() {
		return routeBean;
	}
	/**
	 * @param routeBean rb
	 */
	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}
	/** 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @return pageaction
	 */
	public String execute()
	{
		Map<String, Object> session=ActionContext.getContext().getSession();
		Administrator route =new AdministratorImpl();
		
		String rid=route.addRoute(routeBean);
		if(!("error".equals(rid)))
		{
			System.out.println("in if");
			session.put("routeID", rid);
			return "success";
		}
	
		return "error";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return routeBean;
	}
	
	
	
	/**
	 * 
	 * @return String
	 */
	public String viewAllroutes() {
		Administrator showroutes = new AdministratorImpl();

		routeList = showroutes.viewByAllRoutes();

		if (routeList.isEmpty()) {
			return "error";
		} else {
			return "success";
		}

	}
	/**
	 * 
	 * @return String
	 */
	public String viewRoutebyId() {
		Administrator showroutebyid = new AdministratorImpl();
		routeBean = showroutebyid.viewByRouteId(routeBean.getRouteid());
		return "success";
	}
	/**
	 * 
	 * @return String
	 */
	public String editRoute()
	{
		System.out.println("in the edit methodof route");
		Administrator editroute=new AdministratorImpl();
		boolean a=editroute.modifyRoute(routeBean);
		System.out.println("the returned value is "+a);
		if(a)
		{
			viewAllroutes();
			return "success";
		}
		else
			{
			return "error";
			}
	}

	/**
	 * @return routeid
	 */
	public String getRouteid() {
		return routeid;
	}
	/**
	 * @param routeid rd
	 */
	public void setRouteid(String routeid) {
		this.routeid = routeid;
	}

	/**
	 * 
	 * @return String
	 */
	public String routeDelete()
	{   deleteid.add(this.getAbc());
		Administrator admin =new AdministratorImpl();
		int result =admin.removeRoute(deleteid);
		System.out.println(result);
		if(result==1)
		{	
			System.out.println("in if actrion");
			viewAllroutes();
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
	 * @param abc ab
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
	 * @param deleteid dd
	 */

	public void setDeleteid(ArrayList<String> deleteid) {
		this.deleteid = deleteid;
	}
}
