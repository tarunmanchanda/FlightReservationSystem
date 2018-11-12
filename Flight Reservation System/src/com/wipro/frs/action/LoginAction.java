/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:eW3
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

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.wipro.frs.bean.CredentialsBean;
import com.wipro.frs.bean.ProfileBean;
import com.wipro.frs.util.User;
import com.wipro.frs.util.UserImpl;
/**
 * 
 * @author TARUN MANCHANDA
 * @author AASHISH
 * @version 1.0
 * @since 1.0 Date : Apr 3, 2015
 */
public class LoginAction extends ActionSupport implements ModelDriven{
		
		private transient CredentialsBean credentialsBean =new CredentialsBean ();
		private transient ProfileBean profileBean =new ProfileBean();
		
		

		/**
		 * @return profileBean
		 */
		public ProfileBean getProfileBean() {
			return profileBean;
		}
		/**
		 * @param profileBean pb
		 */
		public void setProfileBean(ProfileBean profileBean) {
			this.profileBean = profileBean;
		}
		

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
		 * @see com.opensymphony.xwork2.ActionSupport#execute()
		 * @return pageaction
		 */
		
		public String execute()
		{	
			Map<String,Object> session=ActionContext.getContext().getSession();
			User obj=new UserImpl();
			session.put("userid", credentialsBean.getUserid());
			String result=obj.login(credentialsBean);
			if("A".equals(result))
			{	
				if(credentialsBean.getPassword().equals("admin"))
				{
					System.out.println("setting id :"+session.get("userid"));
					return "changepassword";
				
				}
				else if("A".equals(result))
				{
					return "adminsuccess";
				}
			
			}
			else if("C".equals(result))
			{
				Map<String,Object> session1=ActionContext.getContext().getSession();
			//	System.out.println("setting id :"+session1.get("userid"));
				//session1.get("userid");
				
				return "customersuccess";
				
			}
			else if("fail".equals(result))
			{
				return "fail";
			}
			else if("invalid".equals(result))
			{
				
				if((Integer)session.get("Invaliduser")==1)
				{
					return "userIdDoesNotExist";
				}
				else
				{
					return "incorrectPassword";
				}
		
			}
			return result;
			
		}	

	
		/**
		 * @return credentialsBean


		 */
		public Object getModel() {
			
			return credentialsBean;
		}

		/**
		 * 
		 * @return String
		 */
		
		public String LogoutMethod()
		{
			Map session=ActionContext.getContext().getSession();
			User user=new UserImpl();
			if(user.logout((String)session.get("userid")))
			{
				return "success";	
			}
			return "error";
			
		}
		
		
	/*	public String Registration()
		{
			Map session=ActionContext.getContext().getSession();
			User user1=new UserImpl();
			String result=user1.register(profileBean);
			
			if(result.equals("success"))
			{
				return "success";
			}
			else if(result.equals("fail"))
			{
				return "failed";
			}
			else
			{
				return "invalidd";
			}
			
		}*/
		
		
	}
		


