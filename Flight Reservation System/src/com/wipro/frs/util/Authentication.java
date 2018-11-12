package com.wipro.frs.util;

import com.wipro.frs.bean.CredentialsBean;

public interface Authentication {
	/**
	 * 
	 * @param credentialsBean cb
	 * @return boolean
	 */
    boolean authenticate(CredentialsBean credentialsBean); 
/**
 * 
 * @param userId ud
 * @return String
 */
    String authorize(String userId); 
    /**
     * 
     * @param credentialsBean cb
     * @param loginStatus ls
     * @return boolean
     */
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);

}
