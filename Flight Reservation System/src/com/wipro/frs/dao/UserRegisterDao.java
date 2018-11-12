package com.wipro.frs.dao;

import com.wipro.frs.bean.CreditCardBean;
import com.wipro.frs.bean.ProfileBean;
public interface UserRegisterDao {
	/**
	 * 
	 * @param profileBean pb
	 * @return String
	 */
	String createUser(ProfileBean profileBean);
	/**
	 * 
	 * @param creditcardBean cb
	 * @return String
	 */
	String addCreditCard(CreditCardBean creditcardBean );
}
