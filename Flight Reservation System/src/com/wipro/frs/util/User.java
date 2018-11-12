package com.wipro.frs.util;

import com.wipro.frs.bean.CredentialsBean;
import com.wipro.frs.bean.ProfileBean;

public interface User {

/**
 * 	
 * @param credentialsBean cb
 * @return String
 */
	String login(CredentialsBean credentialsBean);
	/**
	 * 
	 * @param credentialsBean cd
	 * @param newPassword np
	 * @return String
	 */
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	/**
	 * 
	 * @param userId ud
	 * @return boolean
	 */
	boolean logout(String userId) ;
	/**
	 * 
	 * @param profileBean pb
	 * @return String
	 */
	String register(ProfileBean profileBean) ;
}
