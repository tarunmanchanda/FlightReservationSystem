/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:
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

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.wipro.frs.util.User;
import com.wipro.frs.util.UserImpl;
import com.wipro.frs.bean.CredentialsBean;

/**
 * 
 * @author TARUN MANCHANDA
 * @author AASHISH
 * @version 1.0
 * @since 1.0 Date : Apr 3, 2015
 */
public class UpdateAdminPasswordAction extends  ActionSupport implements ModelDriven{
	
	private transient String newpassword;
	private transient CredentialsBean credentialsBean =new CredentialsBean ();
	
	/**
	 * @return credentialsBean
	 */
	public CredentialsBean getCredentialsBean() {
	return credentialsBean;
	}
	/**
	 * @param credentialsBean cb
	 */
	public void setCredentialsBean(CredentialsBean credentialsBean) {
		this.credentialsBean = credentialsBean;
	}
	/**
	 * @return newpassword
	 */
	public String getNewpassword() {
		return newpassword;
	}
	/**
	 * @param newpassword np
	 */
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	/** 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @return pageaction
	 */


	public String execute() 
	{
		User user=new UserImpl();
		String up= user.changePassword(credentialsBean, getNewpassword());
		
		
		if("updatesuccess".equals(up))
		{
			return "updatesuccess";
		}
		else if("updatefailed".equals(up))
		{
			return "updatefailed";
		}
		else
		{
			return "updateinvalid";
		}
		
		}
	public String execute1() 
	{
		User user=new UserImpl();
		String up= user.changePassword(credentialsBean, getNewpassword());
		
		
		if("updatesuccess".equals(up))
		{
			return "updatesuccess";
		}
		else if("updatefailed".equals(up))
		{
			return "updatefailed";
		}
		else
		{
			return "updateinvalid";
		}
		
		}
	/**
	 * @return credentialsBean


	 */

	public Object getModel() {
		
		return credentialsBean;
	}

	
	
	
	
	
}
