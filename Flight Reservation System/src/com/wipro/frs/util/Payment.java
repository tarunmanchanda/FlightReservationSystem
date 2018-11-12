package com.wipro.frs.util;

import com.wipro.frs.bean.CreditCardBean;


public interface Payment {
	boolean findByCardNumber(String userid, String creditcardnumber);
	String process(CreditCardBean creditCardBean);
}
