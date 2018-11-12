/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:
 * 
 *
 * File Name       : FlightAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :April 3, 2015
 * 
 */
package com.wipro.frs.action;


import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.wipro.frs.bean.ProfileBean;
import com.wipro.frs.dao.UserRegisterDao;
import com.wipro.frs.dao.UserRegisterDaoImpl;

/**
 * 
 * @author TARUN MANCHANDA
 * @author AASHISH
 * @version 1.0
 * @since 1.0 Date : Apr 3, 2015
 */
public class UserRegisterAction extends ActionSupport implements ModelDriven<Object>
{
		private static final long serialVersionUID = -3459810516977738831L;
		private transient ProfileBean profileBean=new ProfileBean();
		@Override
		public Object getModel() {
			return profileBean;
		}

/** 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @return pageaction
	 */
		public String execute()
		{
			Map<String, Object> session=ActionContext.getContext().getSession();
			UserRegisterDao user=new UserRegisterDaoImpl();
			String uid=user.createUser(profileBean);
			if(!"error".equals(uid))
			{
				session.put("registeredID", uid);
				return "success";
			}
			addActionError("UserNotRegistered");
			return "error";
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	

