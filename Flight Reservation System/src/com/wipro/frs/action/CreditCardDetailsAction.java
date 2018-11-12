/*
 *
 * Copyright 2015 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice:tF4
 * 
 * File Name       : CreditCardAction.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :Apr 3, 2015
 * 
 */
package com.wipro.frs.action;

import com.opensymphony.xwork2.ModelDriven;


import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.dao.UserRegisterDao;
import com.wipro.frs.dao.UserRegisterDaoImpl;
/**
 * 
 * @author TARUN MANCHANDA
 * @author AASHISH
 * @version 1.0
 * @since 1.0 Date : Apr 3, 2015
 */


public class CreditCardDetailsAction implements ModelDriven<Object>{

	private CreditCardBean creditcardBean=new CreditCardBean();
/**
 * @return creditcardBean
 */
public Object getModel() {
		return creditcardBean;
	}
	/** 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 * @return pageaction
	 */

	public String execute()
	{
		UserRegisterDao user=new UserRegisterDaoImpl();
		String ad=user.addCreditCard(creditcardBean );
		if("creditdetailsuccess".equals(ad))
		{
			return "success";
		}
		else
		{
			return "error";
		}
		
		
	}
	
}
