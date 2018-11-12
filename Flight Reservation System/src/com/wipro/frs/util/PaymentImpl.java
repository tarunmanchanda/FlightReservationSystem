package com.wipro.frs.util;

import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.dao.CreditCardDAO;
import com.wipro.frs.dao.CreditCardDAOImpl;

public class PaymentImpl implements Payment {

	@Override
	public boolean findByCardNumber(String userid, String creditcardnumber) {
		// TODO Auto-generated method stub
		
			CreditCardDAO cardObj=new CreditCardDAOImpl();
			boolean result=cardObj.findByCardNumber(userid, creditcardnumber);
			System.out.println("inside find by crad nu method payment");
			return result;
		
	
	}

	@Override
	public String process(CreditCardBean creditcardBean) {
		// TODO Auto-generated method stub
		CreditCardDAO cardobj=new CreditCardDAOImpl();
		boolean result=cardobj.updateCreditCardBalance(creditcardBean);
		if(result)
		{
			return "success";
		}
		else
		{
			return "error";
		}
	}


	}


