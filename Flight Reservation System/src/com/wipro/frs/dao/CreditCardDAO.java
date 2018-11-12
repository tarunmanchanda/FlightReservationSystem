package com.wipro.frs.dao;

import com.wipro.frs.bean.CreditCardBean;

public interface CreditCardDAO {

	
	
	//	public int insertDetails(CreditCardBean creditcardBean,String userid);
		public boolean findByCardNumber(String userid, String creditcardnumber);
		public boolean updateCreditCardBalance(CreditCardBean creditcardBean); 

	
}
